package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

// SUGGEST: Strongly type Object[] as Resolved[] in provide(...).
public final class DefaultProviderEngine implements ProviderEngine {
    private static final Interface CONSTRUCTABLE = new DefaultInterface(Constructable.class);
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final Onionizer onionizer;
    private final Instantiator instantiator;
    private final InjectorEngine injector;

    public DefaultProviderEngine(Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    // FIX 2215 Interface iface has been recently added.  Is this the right direction?
    // FIX 2215 Perhaps we should revert to just Implementation and do the inProgress.put() some other way.
    // FIX 2237 Should be able to remove iface parameter soon.
    public ResolvedInstance provide(Implementation impl, Object[] parameters) {
        ResolvedInstance resolved = getResolvedInstance(impl, parameters);
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolved);
        return onionizer.onionise(impl, resolved);
    }

    private ResolvedInstance getResolvedInstance(Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        inject(impl, unresolved);
        return (ResolvedInstance) unresolved;
    }

    private void inject(Implementation impl, UnresolvedInstance unresolved) {
        try {
            inProgress.put(impl, unresolved);
            injector.inject(unresolved);
        } finally {
            inProgress.remove(impl);
        }
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
