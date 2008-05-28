package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;

public final class DefaultInjectionSiteBuilder implements InjectionSiteBuilder {
    private final InjectionTypeBuilder builder = new DefaultInjectionTypeBuilder();

    public InjectionSite build(Field field) {
        Class<?> host = field.getDeclaringClass();
        String name = field.getName();
        Type reified = field.getGenericType();
        InjectionType type = injectionType(reified);
        return new DefaultInjectionSite(host, type, name);
    }

    public InjectionSite[] build(Constructor constructor) {
        throw new UnsupportedOperationException();
    }

    private InjectionType injectionType(Type type) {
        return builder.build(type);
    }
}
