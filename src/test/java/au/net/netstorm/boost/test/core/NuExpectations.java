package au.net.netstorm.boost.test.core;

public interface NuExpectations {
    <T> void nu(T obj, Class<? extends T> impl, Object... params);
}
