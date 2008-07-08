package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface InjectionSiteChecker {
    void check(InjectionSite subject, Class<?> host, InjectionType type, String name);
}
