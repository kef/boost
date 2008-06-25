package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.spider.linkage.Linkage;

// FIX 2328 encapsulate injection site info, reified type, host class, field name
public interface InjectionSite {
    Class<?> host();
    InjectionType type();
    String name();

    // FIX 2328 incremental step, eventually just use injection sites where applicable
    Linkage toLinkage();
}
