package au.net.netstorm.boost.test.core;

public interface NuExpectations {
    <T> void nu(T obj, Class<T> impl, Object... params);
}
