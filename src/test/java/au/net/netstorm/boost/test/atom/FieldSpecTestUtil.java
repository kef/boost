package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface FieldSpecTestUtil {
    Class[] getTypes(FieldSpec[] fields);

    Object[] getInstances(FieldSpec[] fields);
}
