package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public final class DefaultFieldRetriever implements FieldRetriever {

    public Field[] retrieve(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return siftOutSyntheticFields(fields);
    }

    // FIX 35593 Delegate to a field inspector.
    // SUGGEST: Can maybe be replaced with field.isSynthetic() in 1.5?
    private Field[] siftOutSyntheticFields(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (!field.getName().contains("$")) {
                result.add(field);
            }
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }
}
