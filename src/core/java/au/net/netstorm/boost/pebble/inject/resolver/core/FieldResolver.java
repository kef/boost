package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface FieldResolver {
    ResolvedInstance resolve(Field field);
}
