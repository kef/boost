package au.net.netstorm.boost.spider.core;

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

public final class DefaultPlainProviderEngine implements PlainProviderEngine {
    private static final Interface CONSTRUCTABLE = new DefaultInterface(Constructable.class);
    private final TypeMaster typer = new DefaultTypeMaster();
    private final PartialInstances inProgress;
    private final Instantiator instantiator;
    private final InjectorEngine injector;
    private final Onionizer onionizer;

    public DefaultPlainProviderEngine(
            Instantiator instantiator,
            InjectorEngine injector,
            Onionizer onionizer,
            PartialInstances inProgress) {
        this.inProgress = inProgress;
        this.instantiator = instantiator;
        this.injector = injector;
        this.onionizer = onionizer;
    }

    public ResolvedInstance provide(Implementation impl, Object[] params) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, params);
        return plain(impl, unresolved);
    }

    private ResolvedInstance plain(Implementation impl, UnresolvedInstance unresolved) {
        inject(impl, unresolved);
        return postProcess(impl, unresolved);
    }

    private void inject(Implementation impl, UnresolvedInstance unresolved) {
        inProgress.put(impl, unresolved);
        try {
            injector.inject(unresolved);
        } finally {
            inProgress.remove(impl);
        }
    }

    // FIX ()  94156 Remove dupe with DefaultProxyProviderEngine!!!
    private ResolvedInstance postProcess(Implementation impl, UnresolvedInstance unresolved) {
        ResolvedInstance resolvedInstance = (ResolvedInstance) unresolved;
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolvedInstance);
        // FIX ()  94156 Remove this?
        return onionizer.onionise(impl, resolvedInstance);
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
