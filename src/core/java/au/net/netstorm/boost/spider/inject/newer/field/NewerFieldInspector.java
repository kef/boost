package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;

public interface NewerFieldInspector {
    boolean isNewer(Object ref, Field field);

    NewerField getNewer(Object ref, Field field);
}
