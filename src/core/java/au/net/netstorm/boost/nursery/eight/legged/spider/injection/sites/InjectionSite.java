package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface InjectionSite {
    Class<?> host();
    InjectionType type();
    String name();
    void inject(Object host, Object instance);
}
