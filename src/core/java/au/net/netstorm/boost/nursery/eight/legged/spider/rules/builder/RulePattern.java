package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 experiment in a tidy way to build rules (to part)
public interface RulePattern {
    void to(Factory factory);
    void to(Object instance);
    void to(Class<?> impl);
}
