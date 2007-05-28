package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;

public interface ResolvableFieldFinder {
    Field[] find(Object ref);
}
