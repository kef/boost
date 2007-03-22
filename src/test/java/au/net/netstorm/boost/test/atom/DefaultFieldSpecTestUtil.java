package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldSpecTestUtil implements FieldSpecTestUtil {
    private RandomProvider randomProvider = new DefaultRandomProvider();

    public Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }

    // FIX 1676 Split.  These two methods do completely different things.
    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = randomProvider.get(types[i]);
        }
        return result;
    }
}
