package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataChecker {
    void check(Class cls, FieldSpec[] fields);
}
