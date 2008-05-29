package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface Ruler {
    Mapping map(Class<?> iface);
    Mapping map(InjectionType type);
}
