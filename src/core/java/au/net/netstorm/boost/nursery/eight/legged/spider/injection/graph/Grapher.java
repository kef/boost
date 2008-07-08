package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX BREADCRUMB 2394 bbbbbbbbb implementing wrapper for graph
public interface Grapher {
    <T> T graph(InjectionType<T> type, Object... args);

    <T> T graph(InjectionType<T> type, Provider provider, Object... args);
}
