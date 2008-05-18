package au.net.netstorm.boost.spider.instantiate;

// FIX 2328 Support "edges".

// FIX 2328 MH i think this iface should go all together, once you start abstracting out the creation of
// FIX 2328 MH objects properly, the logic contained by this fellow should be hidden away never to be head from
public interface Nu {
    <T> T nu(Class<T> impl, Object... params);
}
