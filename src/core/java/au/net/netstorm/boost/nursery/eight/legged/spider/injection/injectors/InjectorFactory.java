package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface InjectorFactory<T> {
    // FIX 2394 do we really need an injection site given that the provider has already been resolved
    T nu(InjectionWeb web, InjectionSite site, Provider provider);
}
