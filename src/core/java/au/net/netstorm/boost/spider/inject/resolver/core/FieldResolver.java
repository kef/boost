package au.net.netstorm.boost.spider.inject.resolver.core;

import au.net.netstorm.boost.util.type.ResolvedInstance;

import java.lang.reflect.Field;

public interface FieldResolver {
    ResolvedInstance resolve(Field field);
}
