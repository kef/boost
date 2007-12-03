package au.net.netstorm.boost.provider;

public interface Provider {
    <T> T provide(Class<T> type);
}