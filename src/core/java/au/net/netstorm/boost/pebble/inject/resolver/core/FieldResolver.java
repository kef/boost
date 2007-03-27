package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.util.type.Instance;

public interface FieldResolver {
    Instance resolve(Field field);
}
