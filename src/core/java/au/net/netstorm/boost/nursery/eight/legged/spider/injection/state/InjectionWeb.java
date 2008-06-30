package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface InjectionWeb {
    Provider provider(InjectionSite site);
    Injection injection(InjectionSite site);
}
