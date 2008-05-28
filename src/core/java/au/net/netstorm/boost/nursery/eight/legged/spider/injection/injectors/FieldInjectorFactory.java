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
        Class<?> raw = type.rawClass();
        MemberInjector[] fields = fields(web, raw);
        return new DefaultMemberInjector(fields); 
    }

    private MemberInjector[] fields(InjectionWeb web, Class<?> raw) {
        List<MemberInjector> injectors = new ArrayList<MemberInjector>();
        for (Field f : raw.getDeclaredFields()) {
            if (resolvable.isResolvableField(f)) addField(injectors, web, f);
        }
        return injectors.toArray(new MemberInjector[injectors.size()]);
    }

    private void addField(List<MemberInjector> injectors, InjectionWeb web, Field field) {
        InjectionSite site = siteBuilder.build(field);
        Injection injection = web.injection(site);
        MemberInjector injector = new DefaultFieldInjector(injection, field);
        injectors.add(injector);
    }
}
