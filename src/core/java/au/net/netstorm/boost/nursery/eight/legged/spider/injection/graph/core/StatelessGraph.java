package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;

public interface StatelessGraph {
    void build(InjectionSite root, Providers providers, Resolvables resolvables);

    void instantiate(Providers providers, Instances instances);

    void wire(Instances instances, Resolvables resolvables);

    void post(Providers providers, Instances instances);
}
