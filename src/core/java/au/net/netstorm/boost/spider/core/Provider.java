package au.net.netstorm.boost.spider.core;

public interface Provider {
    Object provide(Class type);

    // FIX BREADCRUMB 1977 FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF Remove me.
    Object provide(Class type, Object[] parameters);
}