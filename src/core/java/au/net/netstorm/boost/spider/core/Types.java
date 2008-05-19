package au.net.netstorm.boost.spider.core;

// FIX 2328 Support "edges" interface.
// FIX (Nov 21, 2007) 2233 Move out of nursery
// FIX 2328 this guy needs to handle the subclass instantiation gracefully so we can kill Nu (see AutoEdger#nee)
public interface Types {
    <T> T nu(Class<T> iface, Object... values);
}
