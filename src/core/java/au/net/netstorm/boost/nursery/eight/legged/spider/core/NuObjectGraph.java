package au.net.netstorm.boost.nursery.eight.legged.spider.core;

public interface NuObjectGraph {
    <T> T nu(Class<T> root, Object... args);
}
