package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;

public interface FieldInspector {

    boolean isCreator(Object ref, Field field);

    CreatorField getCreator(Field declaredField, Object ref);
}
