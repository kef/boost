package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface FieldRandomizer {
    Object[] getInstances(FieldSpec[] fields);
}
