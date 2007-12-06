package au.net.netstorm.boost.test.core;

public interface TypesExpectations {
    <T> void types(T obj, Class<? extends T> impl, Object... params);
}
