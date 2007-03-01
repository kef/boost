package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class AutoMockFieldRetriever implements FieldRetriever {

    public BoostField[] retrieve(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return doRetrieve(ref, fields);
    }

    // SUGGEST: Can maybe be replaced with field.isSynthetic() in 1.5?
    private BoostField[] doRetrieve(Object ref, Field[] fields) {
        List eligibleFields = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            examine(ref, eligibleFields, fields[i]);
        }
        return (BoostField[]) eligibleFields.toArray(new BoostField[]{});
    }

    private void examine(Object ref, List list, Field field) {
        BoostField boostField = new DefaultBoostField(ref, field);
        if (boostField.isMockable()) list.add(boostField);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }
}
