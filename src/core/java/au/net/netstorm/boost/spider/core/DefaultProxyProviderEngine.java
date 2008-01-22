package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

// FIX ()  94156 Rename to UglyBetty - yes, this is not nice.

// DEBT LineLength|NCSS {
public final class DefaultProxyProviderEngine implements ProxyProviderEngine {
    private static final Interface CONSTRUCTABLE = new DefaultInterface(Constructable.class);
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ProxyEngine proxyEngine = new DefaultProxyEngine(this);
    private final ProxyFactory proxyFactory = new DefaultProxyFactory();
    private final PartialInstances inProgress;
    private final InjectorEngine injector;
    private final Instantiator instantiator;
    private final Onionizer onionizer;

    public DefaultProxyProviderEngine(
            Instantiator instantiator,
            InjectorEngine injector,
            Onionizer onionizer,
            PartialInstances inProgress) {
        this.instantiator = instantiator;
        this.injector = injector;
        this.onionizer = onionizer;
        this.inProgress = inProgress;
    }

    // FIX ()  94156 dodgy boy
    public ResolvedInstance provide(Implementation impl, Object[] params) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, params);
        injector.inject(unresolved);
        return postProcess(impl, unresolved);
    }

    // FIX ()  94156 This is still horrible.
    public ResolvedInstance provide(Interface iface, Implementation impl, Object[] params, Class<? extends Layer>... layers) {
        PassThroughLayer passThroughLayer = new DefaultPassThroughLayer();
        Object proxy = proxyFactory.newProxy(iface, passThroughLayer);
        UnresolvedInstance unresolved = new DefaultBaseReference(proxy);
        inProgress.put(impl, unresolved);
        try {
            ResolvedInstance fred = provide(impl, params, layers);
            Object ref = fred.getRef();
            passThroughLayer.setDelegate(ref);
            return (ResolvedInstance) unresolved;
        } finally {
            inProgress.remove(impl);
        }
    }

    private ResolvedInstance provide(Implementation impl, Object[] params, Class<? extends Layer>... layers) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, params);
        return proxy(impl, unresolved, layers);
    }

    private ResolvedInstance proxy(Implementation impl, UnresolvedInstance unresolved, Class<? extends Layer>... layers) {
        injector.inject(unresolved);
        UnresolvedInstance proxy = proxy(unresolved, layers);
        return postProcess(impl, proxy);
    }

    private UnresolvedInstance proxy(UnresolvedInstance unresolved, Class<? extends Layer>... layers) {
        Object ref = unresolved.getRef();
        Object proxy = proxyEngine.proxy(ref, layers);
        return new DefaultBaseReference(proxy);
    }

    private ResolvedInstance postProcess(Implementation impl, UnresolvedInstance unresolved) {
        ResolvedInstance resolved = (ResolvedInstance) unresolved;
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolved);
        // FIX ()  94156 Remove this?
        return onionizer.onionise(impl, resolved);
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
// } DEBT LineLength|NCSS
