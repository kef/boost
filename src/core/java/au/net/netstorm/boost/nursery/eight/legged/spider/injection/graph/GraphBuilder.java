package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface GraphBuilder {
    // FIX 2394 root arg could be dropped if injection type was parameterized
    <T> InjectionGraph<T> build(Class<T> root, InjectionType type, Object... args);
}
