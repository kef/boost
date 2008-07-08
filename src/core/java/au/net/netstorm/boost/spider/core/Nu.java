package au.net.netstorm.boost.spider.core;

// FIX 2328 Support "edges" interface.
public interface Nu {
    <T> T nu(Class<T> iface, Object... values);
}
