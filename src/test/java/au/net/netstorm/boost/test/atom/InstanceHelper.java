package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface InstanceHelper {
    Object getInstance(Class cls, Object[] parameters);

    Object[] getInstances(FieldSpec[] fields);
}
