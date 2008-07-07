package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. wiring into new Injections interface.
public interface InjectionsBuilder {
    Injections build(InjectionSite site);
    void build(Injections injections, InjectionSite site);
}
