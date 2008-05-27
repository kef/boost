package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;

public interface KeyedRules {
    boolean exists(InjectionType type);

    Iterable<KeyedRule> get(InjectionType type);
}
