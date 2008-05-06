package au.net.netstorm.boost.gunge.provider;

// FIX 2318 Looks just like the "Resolver" too.
// FIX 2318 Where do you really belong my lovely puff pastry.

// FIX 2290 Move into "spider" area.  This is not a top level package.
public interface Provider {
    <T> T provide(Class<T> type);
}