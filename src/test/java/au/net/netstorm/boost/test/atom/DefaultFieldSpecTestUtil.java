package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC600 Narrow scope in this package.  Private classes for all but DDTC.
final class DefaultFieldSpecTestUtil implements FieldSpecTestUtil {
    public Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
