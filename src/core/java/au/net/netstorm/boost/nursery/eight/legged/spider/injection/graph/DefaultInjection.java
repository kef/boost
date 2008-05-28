package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.DefaultFieldInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.DefaultConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;

// FIX BREADCRUMB 2328 driving me up
// FIX 2394 this is a beast, maybe split into pre and post injection phases???
public final class DefaultInjection implements PhasedInjection {
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();
    private final InjectionSite site;
    private final InjectionType type;
    private final List<FieldInjector> fields;
    private ConstructorInjector constructor;

    public DefaultInjection(InjectionSite site) {
        this.site = site;
        this.type = site.type();
        this.fields = new ArrayList<FieldInjector>();
    }

    public void build(InjectionContext context) {
        preInjections(context);
        postInjections(context);
    }

    public Object apply() {
        Object instance = constructor.inject();
        for (FieldInjector injector : fields) injector.inject(instance);
        return instance;
    }

    private void preInjections(InjectionContext context) {
        Provider provider = context.provider(site);
        Constructor<?> ctor = getConstructor();
        InjectionSite[] sites = siteBuilder.build(ctor);
        Injection[] injections = new Injection[sites.length];
        for (int i = 0; i < sites.length; ++i) {
            injections[i] = context.injection(sites[i]);
        }
        constructor = new DefaultConstructorInjector(provider, injections);
    }

    private void postInjections(InjectionContext context) {
        Class<?> c = type.rawClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            if (resolvable.isResolvableField(f)) addField(context, f);
        }
    }

    private Constructor<?> getConstructor() {
        Class<?> c = type.rawClass();
        Constructor<?>[] ctors = c.getConstructors();
        if (ctors.length != 1) throw new IllegalArgumentException();
        return ctors[0];
    }

    private void addField(InjectionContext context, Field field) {
        InjectionSite site = siteBuilder.build(field);
        Injection injection = context.injection(site);
        FieldInjector injector = new DefaultFieldInjector(injection, field);
        fields.add(injector);
    }
}
