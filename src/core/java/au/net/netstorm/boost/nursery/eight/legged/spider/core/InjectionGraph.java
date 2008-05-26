package au.net.netstorm.boost.nursery.eight.legged.spider.core;

public interface InjectionGraph<T> {
    T apply(Object... args);
}