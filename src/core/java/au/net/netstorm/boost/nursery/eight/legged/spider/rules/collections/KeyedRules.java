package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;

public interface KeyedRules {
    boolean exists(InjectionType type);

    List<KeyedRule> get(InjectionType type);
}
