package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface InjectorFactory<T> {
    T nu(InjectionWeb web, InjectionSite site);
}
