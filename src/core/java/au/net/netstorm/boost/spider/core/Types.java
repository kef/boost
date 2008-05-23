package au.net.netstorm.boost.spider.core;

// FIX 2328 Support "edges" interface.
// FIX (Nov 21, 2007) 2233 Move out of nursery
// FIX BREADCRUMB 2394 renaming in progress...
public interface Types {
    <T> T nu(Class<T> iface, Object... values);
}
