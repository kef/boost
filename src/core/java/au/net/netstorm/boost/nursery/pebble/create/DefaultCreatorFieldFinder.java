package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.HashSet;

public final class DefaultCreatorFieldFinder implements CreatorFieldFinder {
    public CreatorField[] find(Object ref) {
        Set creatorFields = new HashSet();
        Field[] declaredFields = ref.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            addCreatorField(declaredFields[i], creatorFields);
        }
        return (CreatorField[]) creatorFields.toArray(new CreatorField[]{});
    }

    private void addCreatorField(Field declaredField, Set creatorFields) {
        Class type = declaredField.getType();
        String name = declaredField.getName();
        creatorFields.add(new DefaultCreatorField(type, name));
    }
}
