package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.fail;

public final class DefaultRuleResolverChecker implements RuleResolverChecker {
    public void checkResolved(RuleResolver resolver, InjectionSite site, Rule expected) {
        Rule result = resolver.resolve(site);
        assertSame(expected, result);                
    }

    public void checkUnResolvable(RuleResolver resolver, InjectionSite site) {
        try {
            resolver.resolve(site);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
