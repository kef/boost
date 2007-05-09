package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

// FIX 1665 Sort this coupling out.
// FIX 1665 Split this based on field.  Have a single NewerFieldChecker (or something).

public final class DefaultNewerFieldFinder implements NewerFieldFinder {
    // FIX 1665 Should be passed in via the constructor.
    private NewerFieldInspector newerFieldInspector = new DefaultNewerFieldInspector();
    private NewerFieldBuilder newerFieldBuilder = new DefaultFieldBuilder();

    public NewerField[] find(Object ref) {
        Field[] declaredFields = getDeclaredFields(ref);
        return find(ref, declaredFields);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class refType = ref.getClass();
        return refType.getDeclaredFields();
    }

    private NewerField[] find(Object ref, Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            add(result, fields[i], ref);
        }
        return (NewerField[]) result.toArray(new NewerField[]{});
    }

    private void add(Set result, Field field, Object ref) {
        if (!newerFieldInspector.isNewer(ref, field)) return;
        NewerField newer = newerFieldBuilder.build(field);
        result.add(newer);
    }
}
