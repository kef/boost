package au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules;

import au.net.netstorm.boost.spider.registry.Factory;

public interface RulePattern {
    void toFactory(Factory factory);
    void to(Object instance);
    void to(Class<?> impl);
}
