package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface FieldResolver {
    ResolvedInstance resolve(Field field);
}
