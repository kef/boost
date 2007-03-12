package au.net.netstorm.boost.pebble.create.field;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

// FIX 1665 Sort this coupling out.
// FIX 1665 Split this based on field.  Have a single CreatorFieldChecker (or something).

public final class DefaultCreatorFieldFinder implements CreatorFieldFinder {
    // FIX 1665 Should be passed in via the constructor.
    private CreatorFieldInspector creatorFieldInspector = new DefaultCreatorFieldInspector();

    public PebbleField[] find(Object ref) {
        Field[] declaredFields = getDeclaredFields(ref);
        return find(ref, declaredFields);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class refType = ref.getClass();
        return refType.getDeclaredFields();
    }

    private PebbleField[] find(Object ref, Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            add(result, fields[i], ref);
        }
        return (PebbleField[]) result.toArray(new PebbleField[]{});
    }

    private void add(Set result, Field field, Object ref) {
        if (!creatorFieldInspector.isCreator(ref, field)) return;
        PebbleField creator = creatorFieldInspector.getCreator(ref, field);
        result.add(creator);
    }
}
