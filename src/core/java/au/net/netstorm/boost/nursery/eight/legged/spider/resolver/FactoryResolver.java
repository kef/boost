package au.net.netstorm.boost.nursery.eight.legged.spider.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;

public interface FactoryResolver {
    Factory resolve(InjectionSite site);
}
