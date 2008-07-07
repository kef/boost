package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. phase 1 of new Injections.
public final class DefaultInstantiationBuilder implements InstantiationBuilder {
    public void build(Injections injections, InjectionSite site) {
        Provider provider = injections.provide(site);
        Instantiator instaniator = new DefaultInstantiator();
        injections.instantiate(site, instaniator);
    }
}
