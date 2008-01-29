package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.nursery.proxy.DefaultProxfierWirer;
import au.net.netstorm.boost.nursery.proxy.Proxifier;
import au.net.netstorm.boost.nursery.proxy.ProxifierWirer;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
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

// FIX ()   94156 Split.
// SUGGEST: Strongly type Object[] as Resolved[] in provide(...).

// DEBT DataAbstractionCoupling {
public final class DefaultProviderEngine implements ProviderEngine {
    private static final Interface CONSTRUCTABLE = new DefaultInterface(Constructable.class);
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory();
    private final ProxifierWirer proxifierWirer = new DefaultProxfierWirer(this);
    private final Proxifier proxifier = proxifierWirer.get();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final Instantiator instantiator;
    private final InjectorEngine injector;
    private final Onionizer onionizer;
    private final Layers proxies;

    // FIX 2237 REMOVE THE BAD ASS PROXIFIER NOW.  LOOK IN THE FIELDS.
    public DefaultProviderEngine(
            Onionizer onionizer,
            InjectorEngine injector,
            Instantiator instantiator,
            Layers proxies
    ) {
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
        this.proxies = proxies;
    }

    public ResolvedInstance provide(Implementation impl, Object[] parameters) {
        ResolvedInstance resolved = getResolvedInstance(impl, parameters);
        return postProcess(impl, resolved);
    }

    private ResolvedInstance getResolvedInstance(Implementation impl, Object[] parameters) {
        if (proxies.exists(impl)) return resolveProxy(impl, parameters);
        return resolvePlain(impl, parameters);
    }

    private ResolvedInstance resolveProxy(Implementation impl, Object[] parameters) {
        PassThroughLayer passThroughLayer = new DefaultPassThroughLayer();
        UnresolvedInstance passThrough = passThrough(impl, passThroughLayer);
        inProgress.put(impl, passThrough);
        try {
            ResolvedInstance instance = proxy(impl, parameters);
            set(passThroughLayer, instance);
            return (ResolvedInstance) passThrough;
        } finally {
            inProgress.remove(impl);
        }
    }

    private ResolvedInstance resolvePlain(Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        inProgress.put(impl, unresolved);
        try {
            return inject(unresolved);
        } finally {
            inProgress.remove(impl);
        }
    }

    private void set(PassThroughLayer passThroughLayer, ResolvedInstance instance) {
        Object ref = instance.getRef();
        passThroughLayer.setDelegate(ref);
    }

    private ResolvedInstance proxy(Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        ResolvedInstance resolved = inject(unresolved);
        ResolvedInstance proxy = proxy(impl, resolved);
        return postProcess(impl, proxy);
    }

    private ResolvedInstance inject(UnresolvedInstance unresolved) {
        injector.inject(unresolved);
        return (ResolvedInstance) unresolved;
    }

    private ResolvedInstance proxy(Implementation impl, ResolvedInstance unresolved) {
        Object ref = unresolved.getRef();
        au.net.netstorm.boost.nursery.proxy.LayerSpec spec = proxies.get(impl);
        Object proxy = proxifier.proxy(ref, spec);
        return new DefaultBaseReference(proxy);
    }

    private UnresolvedInstance passThrough(Implementation impl, PassThroughLayer layer) {
        Interface[] types = typer.interfaces(impl);
        Object proxy = proxyFactory.newProxy(types, layer);
        return new DefaultBaseReference(proxy);
    }

    private ResolvedInstance postProcess(Implementation impl, ResolvedInstance resolved) {
        if (typer.implementz(impl, CONSTRUCTABLE)) construct(resolved);
        return onionizer.onionise(impl, resolved);
    }

    private void construct(ResolvedInstance resolved) {
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
// } DEBT DataAbstractionCoupling