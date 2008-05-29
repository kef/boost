package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class DefaultKeyedRule implements KeyedRule {
    private final Factory factory;
    private final boolean single;
    private final Class<?> host;
    private final String name;

    // FIX 2394 add injection type
    // FIX 2394 abstract out scoped host/name
    public DefaultKeyedRule(Factory factory, boolean single, Class<?> host, String name) {
        this.factory = factory;
        this.single = single;
        this.host = host;
        this.name = name;
    }

    public InjectionType key() {
        throw new UnsupportedOperationException();
    }

    public Factory getFactory() {
        return factory;
    }

    public boolean accepts(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
