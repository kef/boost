package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Grapher {
    <T> T graph(InjectionType<T> type, Object... args);

    <T> T graph(InjectionType<T> type, Provider provider);
}
