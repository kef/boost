package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 experiment in a tidy way to build rules (to part)
public interface RuleTarget {
    RuleScope to(Factory factory);
    RuleScope to(Object instance);
    RuleScope to(Class<?> impl);
}
