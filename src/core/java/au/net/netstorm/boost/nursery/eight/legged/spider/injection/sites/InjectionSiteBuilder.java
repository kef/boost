package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface InjectionSiteBuilder {
    InjectionSite root(InjectionType type);
    InjectionSite fields(Field field);
    // FIX 2394 current plan is to initially use arg0, arg1, ... argn for names
    // FIX 2394 long term it is not that difficult to extract the actual field names from the class file
    InjectionSite[] constructors(Class<?> host, Type[] refieds);
}
