package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;

public final class DefaultKeyedRule implements KeyedRule {
    private final InjectionType type;
    private final Factory factory;
    private final Matcher matcher;

    public DefaultKeyedRule(InjectionType type, Factory factory, Matcher matcher) {
        this.type = type;
        this.factory = factory;
        this.matcher = matcher;
    }

    public InjectionType key() {
        return type;
    }

    public Factory getFactory() {
        return factory;
    }

    public boolean accepts(InjectionSite site) {
        return matcher.accept(site);
    }
}
