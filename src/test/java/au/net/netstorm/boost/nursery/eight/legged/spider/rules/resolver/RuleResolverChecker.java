package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface RuleResolverChecker {
    void checkResolved(RuleResolver resolver, InjectionSite site, Rule expected);
    void checkUnResolvable(RuleResolver resolver, InjectionSite site);
}
