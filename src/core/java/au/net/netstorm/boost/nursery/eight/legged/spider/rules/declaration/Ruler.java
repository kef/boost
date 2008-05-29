package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

public interface Ruler {
    Mapping map(Class<?> iface);
    // FIX 2394 add type token rules:
    // InterfaceMapping map(?InjectionType? type);
}
