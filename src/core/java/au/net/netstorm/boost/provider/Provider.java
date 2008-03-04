package au.net.netstorm.boost.provider;

// FIX 2290 Move into "spider" area.  This is not a top level package.
public interface Provider {
    <T> T provide(Class<T> type);
}