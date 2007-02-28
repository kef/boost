package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// FIX 35593 Delete our field inspector.
public final class AutoMockFieldRetriever implements FieldRetriever {

    public Field[] retrieve(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return doRetrieve(ref, fields);
    }

    // SUGGEST: Can maybe be replaced with field.isSynthetic() in 1.5?
    private Field[] doRetrieve(Object ref, Field[] fields) {
        List eligibleFields = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            examine(ref, eligibleFields, fields[i]);
        }
        return (Field[]) eligibleFields.toArray(new Field[]{});
    }

    private void examine(Object ref, List list, Field field) {
        BoostField boostField = new DefaultBoostField(ref, field);
        if (boostField.isMockable()) list.add(field);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }
}
