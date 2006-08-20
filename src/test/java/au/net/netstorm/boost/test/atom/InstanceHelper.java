package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface InstanceHelper {
    Object getInstance(Class cls, Object[] parameters);

    // FIX SC600 BREADCRUMB Here next.
    // FIX SC600 Make this Class[] types.  Not FieldSpec[].  Makes it more general.
    Object[] getInstances(FieldSpec[] fields);
}
