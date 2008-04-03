package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface FieldRandomizer {
    Object[] getInstances(FieldSpec[] fields);
}
