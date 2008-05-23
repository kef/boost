package au.net.netstorm.boost.spider.core;

// FIX 2328 Support "edges" interface.
// FIX BREADCRUMB 2394 renaming in progress...
public interface Types {
    <T> T nu(Class<T> iface, Object... values);
}
