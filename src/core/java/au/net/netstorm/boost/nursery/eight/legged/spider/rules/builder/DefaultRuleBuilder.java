package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rules;
import static au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.Multiplicity.MULTI;
import static au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.Multiplicity.SINGLE;

// FIX 2394 work out if this is really how i want to do it, looks a little scary
public final class DefaultRuleBuilder implements ApplyableRuleBuilder {
    // FIX 2394 break this out into the three seperate phases
    private final Rules rules;
    private Applyable state;

    public DefaultRuleBuilder(Rules rules) {
        this.rules = rules;
    }

    public RuleTarget single(Class<?> type) {
        return rule(SINGLE, type);
    }

    public RuleTarget multi(Class<?> type) {
        return rule(MULTI, type);
    }

    public WildcardTarget single(TypeMatcher matcher) {
        return wildcard(SINGLE, matcher);
    }

    public WildcardTarget multi(TypeMatcher matcher) {
        return wildcard(MULTI, matcher);
    }

    public void apply() {
        // FIX 2394 instate state check
//        if (state == null) throw new IllegalStateException();
//        state.apply();
    }

    private RuleTarget rule(Multiplicity multi, Class<?> type) {
        ApplyableRuleTarget target = new DefaultRuleTarget(multi, type);
        state = target;
        return target;
    }

    private WildcardTarget wildcard(Multiplicity multi, TypeMatcher matcher) {
        ApplyableWildcardTarget target = new DefaultWildcardTarget();
        state = target;
        return target;
    }
}
