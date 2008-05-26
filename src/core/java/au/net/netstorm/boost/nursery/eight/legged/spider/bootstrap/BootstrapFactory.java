package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.NuInjectionGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;

public final class BootstrapFactory implements ConfigurableFactory {
    private Provider provider;

    public void configure(Web web) {
        // FIX BREADCRUMB 2394 create a NuInjectionGraph and put in web
//        this.provider = new InstanceProvider(...);
        web.single().type(NuInjectionGraph.class).to(this);
    }

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalArgumentException();
        return provider;
    }

    public boolean canHandle(InjectionSite site) {
        return site.isType(NuInjectionGraph.class);
    }
}
