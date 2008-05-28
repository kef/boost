package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver.RuleResolver;

public final class LazyProviderCreator implements Creator<InjectionSite, Provider> {
    private final RuleResolver resolver;

    public LazyProviderCreator(RuleResolver resolver) {
        this.resolver = resolver;
    }

    public Provider create(InjectionSite site) {
        Rule rule = resolver.resolve(site);
        Factory factory = rule.getFactory();
        return factory.nu(site);
    }
}
