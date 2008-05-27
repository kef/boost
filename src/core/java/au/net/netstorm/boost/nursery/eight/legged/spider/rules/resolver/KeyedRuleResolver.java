package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.KeyedRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

final class KeyedRuleResolver implements RuleResolver {
    private final KeyedRules keyed;
    private final RuleResolver delegate;

    // FIX 2394 probably warrants a builder
    public KeyedRuleResolver(KeyedRules keyed, RuleResolver delegate) {
        this.keyed = keyed;
        this.delegate = delegate;
    }

    public Rule resolve(InjectionSite site) {
        InjectionType type = site.type();
        if (!keyed.exists(type)) return delegate(site);
        for (KeyedRule rule : keyed.get(type)) {
            if (rule.accepts(site)) return rule;
        }
        return delegate(site);
    }

    private Rule delegate(InjectionSite site) {
        return delegate.resolve(site);
    }
}
