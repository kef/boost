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

    public InjectionSite fields(Field field) {
        Class<?> host = field.getDeclaringClass();
        Type reified = field.getGenericType();
        InjectionType type = injectionType(reified);
        String name = field.getName();
        return new DefaultFieldInjectionSite(host, type, name);
    }

    // FIX 2394 constructor injection type
    public InjectionSite[] constructors(Class<?> host, Type[] reified) {
        InjectionSite[] sites = new InjectionSite[reified.length];
        for (int i = 0; i < reified.length; ++i) {
            sites[i] = site(host, reified, i);
        }
        return sites;
    }

    private InjectionSite site(Class<?> host, Type[] reified, int i) {
        InjectionType type = injectionType(reified[i]);
        String name = "arg" + i;
        return new DefaultInjectionSite(host, type, name);
    }

    private InjectionType injectionType(Type type) {
        return builder.build(type);
    }
}
