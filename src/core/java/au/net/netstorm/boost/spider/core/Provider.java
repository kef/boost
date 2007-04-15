package au.net.netstorm.boost.spider.core;

public interface Provider {
    Object provide(Class type, Object[] parameters);
}
