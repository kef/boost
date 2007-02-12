package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.util.Set;

public interface FieldInspector {
    void creatorFieldChecker(Object ref, Field declaredField, Set creatorFields);
}
