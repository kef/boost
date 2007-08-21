package au.net.netstorm.boost.spider.core;

public interface GraphUtil {
    Object get(Object ref, String chain);

    void set(Object ref, String chain, Object instance);
}
