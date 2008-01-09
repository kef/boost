package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class DefaultFieldNameFinder implements FieldNameFinder {
    private final EdgeClass classer = new DefaultEdgeClass();

    public List find(Object ref) {
        Field[] fields = getFields(ref);
        return toFieldNameList(fields);
    }

    private Field[] getFields(Object ref) {
        Class cls = ref.getClass();
        return classer.getDeclaredFields(cls);
    }

    private List toFieldNameList(Field[] fields) {
        List fieldList = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            fieldList.add(name);
        }
        return fieldList;
    }
}
