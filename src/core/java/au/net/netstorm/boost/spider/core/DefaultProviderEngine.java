package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// SUGGEST: Strongly type Object[] as Resolved[] in provide(...).
// DEBT LineLength {

// FIX ()  94156 Remove this.  Just go straight to the parts?
public final class DefaultProviderEngine implements ProviderEngine {
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final PlainProviderEngine plain;
    private final ProxyProviderEngine proxy;

    public DefaultProviderEngine(Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        plain = new DefaultPlainProviderEngine(instantiator, injector, onionizer, inProgress);
        proxy = new DefaultProxyProviderEngine(instantiator, injector, onionizer, inProgress);
    }

    public ResolvedInstance provide(Implementation impl, Object[] params) {
        return plain.provide(impl, params);
    }

    public ResolvedInstance provide(Interface iface, Implementation impl, Object[] params, Class<? extends Layer>... layers) {
        return proxy.provide(iface, impl, params, layers);
    }
}
// } DEBT LineLength