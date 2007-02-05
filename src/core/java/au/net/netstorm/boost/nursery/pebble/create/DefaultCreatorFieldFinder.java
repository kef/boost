package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.HashSet;
import au.net.netstorm.boost.reflect.ClassMaster;

public final class DefaultCreatorFieldFinder implements CreatorFieldFinder {
    private ClassMaster classMaster;

    public DefaultCreatorFieldFinder(ClassMaster classMaster) {
        this.classMaster = classMaster;
    }

    public CreatorField[] find(Object ref) {
        Set creatorFields = new HashSet();
        Field[] declaredFields = ref.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            if (isCreatorField(field)) {
                addCreatorField(field, creatorFields);
            }
        }
        return (CreatorField[]) creatorFields.toArray(new CreatorField[]{});
    }

    private boolean isCreatorField(Field field) {
        String name = classMaster.getShortName(field.getType());
        return name.startsWith("New");
    }

    private void addCreatorField(Field declaredField, Set creatorFields) {
        Class type = declaredField.getType();
        String name = declaredField.getName();
        creatorFields.add(new DefaultCreatorField(type, name));
    }
}
