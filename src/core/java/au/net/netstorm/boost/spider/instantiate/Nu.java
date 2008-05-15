package au.net.netstorm.boost.spider.instantiate;

// FIX 2328 Support "edges".
public interface Nu {
    <T> T nu(Class<T> impl, Object... params);
}
