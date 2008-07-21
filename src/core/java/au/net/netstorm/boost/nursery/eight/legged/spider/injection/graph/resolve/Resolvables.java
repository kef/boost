package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Resolvables extends Iterable<Resolvable> {
    void add(InjectionSite host, InjectionSite[] sites);
}
