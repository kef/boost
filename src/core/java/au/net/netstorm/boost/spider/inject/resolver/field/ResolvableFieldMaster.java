package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;

public interface ResolvableFieldMaster {
    boolean isResolvableField(Object ref, Field field);
    boolean isResolvableField(Field field);
}
