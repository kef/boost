package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.lang.reflect.Field;

public interface ResolverFieldFinder {
    Field[] find(Object ref);
}
