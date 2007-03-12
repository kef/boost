package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.util.Set;

public interface FieldInspector {
    void creatorFieldChecker(Set result, Object ref, Field declaredField);

    void addCreator(Set creatorFields, Field declaredField, Object ref);

    boolean isCreator(Object ref, Field field);
}
