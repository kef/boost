package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public interface Ruler {
    Mapping map(Class<?> iface);
    void mapAll(RuleConfig rules);
    void register(Factory factory);
    // FIX 2394 add type token rules:
    // InterfaceMapping map(?InjectionType? type);
}
