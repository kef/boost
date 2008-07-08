package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 yuck.
public interface ProviderOperations {
    Class host(InjectionSite site, Provider provider);

    Type[] params(Provider provider);

    Provider root(Provider provider);
}
