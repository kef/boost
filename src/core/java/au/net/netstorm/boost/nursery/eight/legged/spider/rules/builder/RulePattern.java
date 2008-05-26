package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public interface RulePattern {
    void toFactory(Factory factory);
    void to(Object instance);
    void to(Class<?> impl);
}
