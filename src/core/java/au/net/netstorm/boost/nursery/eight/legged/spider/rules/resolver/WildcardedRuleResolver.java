package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.WildcardRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class WildcardedRuleResolver implements RuleResolver {
    private final WildcardRules wildcarded;

    public WildcardedRuleResolver(WildcardRules wildcarded) {
        this.wildcarded = wildcarded;
    }

    public Rule resolve(InjectionSite site) {
        for (WildcardRule rule : wildcarded) {
            if (rule.accepts(site)) return rule;
        }
        throw new IllegalArgumentException("No rules match injection site: " + site);
    }
}
