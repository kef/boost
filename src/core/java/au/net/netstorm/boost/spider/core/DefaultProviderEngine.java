package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
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

// SUGGEST: try/finally around resolved things put/remove.  Consider using try/finally proxy.
public final class DefaultProviderEngine implements ProviderEngine {
    private static final Object LOCK = GodLock.LOCK;
    private static final Interface CONSTRUCTABLE = new DefaultInterface(Constructable.class);
    private static final Object[] NO_PARAMS = {};
    private final ResolvedThings resolved = new DefaultResolvedThings();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final Onionizer onionizer;
    private final Instantiator instantiator;
    private final InjectorEngine injector;

    public DefaultProviderEngine(Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
    }

    public ResolvedInstance provide(Implementation impl) {
        return provide(impl, NO_PARAMS);
    }

    public ResolvedInstance provide(Implementation impl, Object[] parameters) {
        return provideSync(impl, parameters, false);
    }

    private ResolvedInstance provideSync(Implementation impl, Object[] parameters, boolean isLocked) {
        if (resolved.exists(impl)) return resolved.get(impl);
        if (!isLocked) {
            // SUGGEST Need failing test when this is removed.
            synchronized (LOCK) { return provideSync(impl, parameters, true); }
        }
        return createResolved(impl, parameters);
    }

    private ResolvedInstance createResolved(Implementation impl, Object[] parameters) {
        ResolvedInstance resolved = getResolvedInstance(impl, parameters);
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolved);
        return onionizer.onionise(impl, resolved);
    }

    private ResolvedInstance getResolvedInstance(Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        resolved.put(impl, unresolved);
        injector.inject(unresolved);
        resolved.remove(impl);
        return (ResolvedInstance) unresolved;
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
