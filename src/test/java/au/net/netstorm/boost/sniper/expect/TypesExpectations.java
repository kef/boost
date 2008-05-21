package au.net.netstorm.boost.sniper.expect;

public interface TypesExpectations {
    <T> void types(T obj, Class<? extends T> iface, Object... params);
}
