package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;

public final class DefaultFieldResolver implements FieldResolver {
    public Object resolve(Field field) {
        // FIX 1715 This is bollocks.
        return null;
    }
}
