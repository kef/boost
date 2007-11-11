package au.net.netstorm.boost.spider.core;

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
    private static final Object[] NO_PARAMS = {};
    private final TypeMaster typer = new DefaultTypeMaster();
    private final Onionizer onionizer;
    private final Instantiator instantiator;
    private final InjectorEngine injector;

    public DefaultProviderEngine(Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    // FIX 2215 iface is here to link iface, impl, and instantiation together.
    public ResolvedInstance provide(Interface iface, Implementation impl) {
        return provide(iface, impl, NO_PARAMS);
    }

    // FIX 2215 Interface iface has been recently added.  Is this the right direction?
    // FIX 2215 Perhaps we should revert to just Implementation and do the inProgress.put() some other way.
    public ResolvedInstance provide(Interface iface, Implementation impl, Object[] parameters) {
        ResolvedInstance resolved = getResolvedInstance(iface, impl, parameters);
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolved);
        return onionizer.onionise(impl, resolved);
    }

    private ResolvedInstance getResolvedInstance(Interface iface, Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        injector.inject(iface, unresolved);
        return (ResolvedInstance) unresolved;
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
