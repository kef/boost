package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.KeyedRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.WildcardRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultRuleResolver implements RuleResolver {
    private final KeyedRules keyed;
    private final WildcardRules wildcarded;

    public DefaultRuleResolver(KeyedRules keyed, WildcardRules wildcarded) {
        this.keyed = keyed;
        this.wildcarded = wildcarded;
    }

    public Rule resolve(InjectionSite site) {
        InjectionType type = site.type();
        if (keyed.exists(type)) return resolveKeyed(type, site);
        return resolveWildcarded(site);
    }

    private Rule resolveKeyed(InjectionType type, InjectionSite site) {
        for (KeyedRule rule : keyed.get(type)) {
            if (rule.accepts(site)) return rule;
        }
        return resolveWildcarded(site);
    }

    private Rule resolveWildcarded(InjectionSite site) {
        for (WildcardRule rule : wildcarded) {
            if (rule.accepts(site)) return rule;
        }
        throw new IllegalArgumentException("No rules match injection site: " + site);
    }
}
