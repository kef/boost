package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface FieldRandomizer {
    Object[] getInstances(FieldSpec[] fields);
}
