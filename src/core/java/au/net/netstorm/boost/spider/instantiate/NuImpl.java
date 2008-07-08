package au.net.netstorm.boost.spider.instantiate;

// FIX 2328 Support "edges".
public interface NuImpl {
    // FIX 2394 slowly minimising calls to this fellow, will be replaced by Types#nu
    // FIX 2394 one idea for getting rid of this all together is to make direct impls be registered
    <T> T nu(Class<T> impl, Object... params);
}
