package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface DataChecker {
    void check(Class cls, FieldSpec[] fields);
}
