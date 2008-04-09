package au.net.netstorm.boost.sniper.field;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldSpecTestUtil implements FieldSpecTestUtil {
    public Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
