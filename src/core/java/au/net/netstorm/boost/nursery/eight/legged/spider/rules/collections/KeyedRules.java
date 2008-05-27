package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;

public interface KeyedRules {
    boolean exists(InjectionType type);

    // FIX 2394 must be sorted to return most specific rule first
    Iterable<KeyedRule> get(InjectionType type);
}
