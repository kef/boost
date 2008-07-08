package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX BREADCRUMB 2394 bbbbbbbbb implementing wrapper for graph
public interface Grapher {
    Object graph(InjectionType type);

    Object graph(InjectionType type, Provider provider);
}
