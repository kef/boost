package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;

public final class FieldInjectorFactory implements InjectorFactory<MemberInjector> {
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();

    public MemberInjector nu(InjectionWeb web, InjectionSite site) {
        InjectionType type = site.type();
        List<MemberInjector> fields = fields(web, type);
        return new DefaultMemberInjector(fields); 
    }

    private List<MemberInjector> fields(InjectionWeb web, InjectionType type) {
        List<MemberInjector> injectors = new ArrayList<MemberInjector>();
        Class<?> c = type.rawClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            if (resolvable.isResolvableField(f)) addField(injectors, web, f);
        }
        return injectors;
    }

    private void addField(List<MemberInjector> injectors, InjectionWeb web, Field field) {
        InjectionSite site = siteBuilder.build(field);
        Injection injection = web.injection(site);
        MemberInjector injector = new DefaultFieldInjector(injection, field);
        injectors.add(injector);
    }
}
