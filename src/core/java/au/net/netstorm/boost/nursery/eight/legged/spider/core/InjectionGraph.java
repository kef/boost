package au.net.netstorm.boost.nursery.eight.legged.spider.core;

// FIX 2394 type safe wrapper for an injection graph
public interface InjectionGraph<T> {
    T apply(Object... args);
}