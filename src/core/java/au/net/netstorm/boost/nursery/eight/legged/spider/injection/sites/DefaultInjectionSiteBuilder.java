package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;

public final class DefaultInjectionSiteBuilder implements InjectionSiteBuilder {
    private final InjectionTypeBuilder builder = new DefaultInjectionTypeBuilder();

    public InjectionSite build(InjectionType type) {
        return new RootInjectionSite(type);
    }

    public InjectionSite build(Field field) {
        Class<?> host = field.getDeclaringClass();
        Type reified = field.getGenericType();
        InjectionType type = injectionType(reified);
        String name = field.getName();
        return new DefaultInjectionSite(host, type, name);
    }

    public InjectionSite[] build(Class<?> host, Type[] refieds) {
        // FIX 2394 MAG Spelling.  For loop too thick.
        InjectionSite[] sites = new InjectionSite[refieds.length];
        for (int i = 0; i < refieds.length; ++i) {
            InjectionType type = injectionType(refieds[i]);
            String name = "arg" + i;
            sites[i] = new DefaultInjectionSite(host, type, name);
        }
        return sites;
    }

    private InjectionType injectionType(Type type) {
        return builder.build(type);
    }
}
