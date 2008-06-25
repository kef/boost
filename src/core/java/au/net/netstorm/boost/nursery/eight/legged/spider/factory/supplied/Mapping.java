package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface Mapping {
    boolean can(InjectionType type);
    String map(InjectionType type);
}
