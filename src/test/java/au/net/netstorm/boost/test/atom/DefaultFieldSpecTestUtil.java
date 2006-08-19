package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class DefaultFieldSpecTestUtil implements FieldSpecTestUtil {
    public Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
