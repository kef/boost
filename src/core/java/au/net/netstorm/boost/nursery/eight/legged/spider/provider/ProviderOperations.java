package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface ProviderOperations {
    Type[] params(Provider provider);

    Provider root(Provider provider);

    InjectionSite[] constructors(InjectionSite site, Provider provider);

    Class host(InjectionSite site, Provider provider);
}
