package au.net.netstorm.boost.pebble.create.field;

import java.lang.reflect.Field;

public interface CreatorFieldInspector {
    boolean isCreator(Object ref, Field field);

    CreatorField getCreator(Object ref, Field field);
}
