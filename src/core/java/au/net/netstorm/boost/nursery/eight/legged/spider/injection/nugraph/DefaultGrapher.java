package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private FactoryResolver resolver;

    public DefaultGrapher(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    // FIX BREADCRUMB 2394 ccccccccccc implementing GraphWrapper
    public Object graph(InjectionSite site, Provider provider) {


        return null;
    }

}
