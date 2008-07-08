package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface InjectionSiteBuilder {
    InjectionSite root(InjectionType type);
    InjectionSite fields(Field field);
    InjectionSite[] constructors(Class raw, Type[] types);
}
