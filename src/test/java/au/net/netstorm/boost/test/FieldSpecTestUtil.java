package au.net.netstorm.boost.test;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX 1676 Move.
public interface FieldSpecTestUtil {
    Class[] getTypes(FieldSpec[] fields);
}
