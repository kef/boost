package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;

public interface FieldResolver {
    Object resolve(Field field);
}
