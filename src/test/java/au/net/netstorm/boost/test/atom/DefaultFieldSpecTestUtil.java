package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldSpecTestUtil implements FieldSpecTestUtil {
    private RandomProvider randomProvider = new TestRandomProvider();

    public Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = getTypes(fields);
        return randomProvider.getInstances(types);
    }
}
