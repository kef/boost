package au.net.netstorm.boost.sniper.expect;

public interface NuExpectations {
    <T> void nu(T obj, Class<? extends T> iface, Object... params);
}
