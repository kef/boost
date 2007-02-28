package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.util.Set;

// FIX 35593 Rename this.  Conflicts with other FieldInspector.
public interface FieldInspector {
    void creatorFieldChecker(Object ref, Field declaredField, Set creatorFields);
}
