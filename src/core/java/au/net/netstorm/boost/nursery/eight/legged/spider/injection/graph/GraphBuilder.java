package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface GraphBuilder {
    // FIX 2394 root arg could be dropped if injection type was parameterized (which it now is)
    // FIX 2394 currently ellected to leave the redundancy for some simplicity
    <T> InjectionGraph<T> resolve(Class<T> root, InjectionType type);
    <T> InjectionGraph<T> nu(Class<T> root, InjectionType type, Object... args);
    <T> InjectionGraph<T> inject(Class<T> root, InjectionType type, Object instance);
    <T> InjectionGraph<T> nuImpl(Class<T> impl, InjectionType type, Object... args);
}
