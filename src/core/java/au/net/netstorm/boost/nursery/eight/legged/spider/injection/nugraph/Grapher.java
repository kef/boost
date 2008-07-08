package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX BREADCRUMB 2394 bbbbbbbbb implementing wrapper for graph
public interface Grapher {
    <T> T graph(InjectionType<T> type, Object... args);
}
