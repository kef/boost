package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class DefaultKeyedRule implements KeyedRule {
    public DefaultKeyedRule(Factory factory, boolean single, Class<?> host, String name) {
        throw new UnsupportedOperationException();
    }

    public InjectionType key() {
        throw new UnsupportedOperationException();
    }

    public Factory getFactory() {
        throw new UnsupportedOperationException();
    }

    public boolean accepts(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
