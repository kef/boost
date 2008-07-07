package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. phase 1 of new Injections.
public interface InstantiationBuilder {
    void build(Injections injections, InjectionSite site);
}
