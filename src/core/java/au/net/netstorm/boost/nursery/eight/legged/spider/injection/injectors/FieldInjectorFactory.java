package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.HasInjectableTarget;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;

public final class FieldInjectorFactory implements InjectorFactory<MemberInjector> {
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();

    public MemberInjector nu(InjectionWeb web, InjectionSite site, Provider provider) {
        MemberInjector[] fields = provider instanceof HasInjectableTarget
                ? fields(web, provider) : new MemberInjector[0];
        return new DefaultMemberInjector(fields); 
    }

    private MemberInjector[] fields(InjectionWeb web, Provider provider) {
        HasInjectableTarget targeted = (HasInjectableTarget) provider;
        Class<?> target = targeted.getTargetClass();
        return fields(web, target);
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
