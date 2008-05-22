package au.net.netstorm.boost.sniper.expect;

public interface NuImplExpectations {
    <T> void nu(T obj, Class<? extends T> impl, Object... params);
}
