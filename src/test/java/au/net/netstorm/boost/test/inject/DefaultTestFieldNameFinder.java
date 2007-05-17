package au.net.netstorm.boost.test.inject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class DefaultTestFieldNameFinder implements TestFieldNameFinder {
    private final EdgeClass classer = new DefaultEdgeClass();

    public List find(UsesMocks testCase) {
        Field[] fields = getFields(testCase);
        return toFieldNameList(fields);
    }

    private Field[] getFields(UsesMocks testCase) {
        Class cls = testCase.getClass();
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
