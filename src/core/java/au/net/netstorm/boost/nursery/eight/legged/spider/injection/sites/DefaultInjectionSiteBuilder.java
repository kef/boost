package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;

public final class DefaultInjectionSiteBuilder implements InjectionSiteBuilder {
    private final InjectionTypeBuilder types = new DefaultInjectionTypeBuilder();

    public InjectionSite root(InjectionType type) {
        return new DefaultRootInjectionSite(type);
    }

    public InjectionSite fields(Field field) {
        Class<?> host = field.getDeclaringClass();
        Type reified = field.getGenericType();
        InjectionType type = types.build(reified);
        String name = field.getName();
        return new DefaultFieldInjectionSite(host, type, name);
    }

    public InjectionSite[] constructors(Class raw, Type[] reified) {
        InjectionSite[] sites = new InjectionSite[reified.length];
        for (int i = 0; i < reified.length; ++i) {
            sites[i] = site(raw, reified, i);
        }
        return sites;
    }

    private InjectionSite site(Class<?> host, Type[] reified, int i) {
        InjectionType type = types.build(reified[i]);
        String name = "arg" + i;
        // FIX 2395 Should the be new ConstructorInjectionSite
        return new DefaultConstructorInjectionSite(host, type, name);
    }
}
