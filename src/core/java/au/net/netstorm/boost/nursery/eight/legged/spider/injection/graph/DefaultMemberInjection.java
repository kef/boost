package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.DefaultMemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;

public final class DefaultMemberInjection implements MemberInjection {
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();
    private final List<MemberInjector> fields;
    private final InjectionType type;

    public DefaultMemberInjection(InjectionWeb web, InjectionType type) {
        this.type = type;
        this.fields = buildInjectors(web);
    }

    public void apply(Object ref) {
        for (MemberInjector injector : fields) injector.inject(ref);
    }

    private List<MemberInjector> buildInjectors(InjectionWeb web) {
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
        MemberInjector injector = new DefaultMemberInjector(injection, field);
        injectors.add(injector);
    }
}

