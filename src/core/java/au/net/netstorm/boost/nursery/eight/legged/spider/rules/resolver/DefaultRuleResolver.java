package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultRuleResolver implements RuleResolver {
    private final Rules rules;

    public DefaultRuleResolver(Rules rules) {
        this.rules = rules;
    }

    public Rule resolve(InjectionSite site) {
        for (Rule rule : rules) {
            if (rule.accepts(site)) return rule;
        }
        throw new IllegalArgumentException("No rules match injection site: " + site);
    }
}
