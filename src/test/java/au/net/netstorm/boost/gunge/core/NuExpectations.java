package au.net.netstorm.boost.gunge.core;

public interface NuExpectations {
    <T> void nu(T obj, Class<? extends T> impl, Object... params);
}
