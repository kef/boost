package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface FieldSpecTestUtil {
    Class[] getTypes(FieldSpec[] fields);

    Object[] getInstances(FieldSpec[] fields);
}
