package au.net.netstorm.boost.spider.instantiate;

public interface NuImpl {
    <T> T nu(Class<T> impl, Object... params);
}
