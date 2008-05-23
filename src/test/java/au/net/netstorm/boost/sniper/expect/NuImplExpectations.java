package au.net.netstorm.boost.sniper.expect;

public interface NuImplExpectations {
    <T> void nuImpl(T obj, Class<? extends T> impl, Object... params);
}
