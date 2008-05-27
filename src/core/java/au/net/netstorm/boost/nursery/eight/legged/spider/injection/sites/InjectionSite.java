package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2328 encapsulate injection site info, reified type, host class, field name
public interface InjectionSite {
    // FIX 2328 incremental step, eventually just use injection sites where applicable
    Linkage toLinkage();

    // FIX 2394 this is questionable, probably not generic enough,
    // FIX 2394 would probably be better with some simple getters wrapped by a query class
    boolean isType(Class<?> cls);

    InjectionType type();

    // FIX 2394 requires pretty printing to string
}
