package au.net.netstorm.boost.spider.instantiate;

public interface Nu {
    <T> T nu(Class<T> impl, Object... params);
}
