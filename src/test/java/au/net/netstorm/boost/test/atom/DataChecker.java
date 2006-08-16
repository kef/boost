package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC600 ? Merge with DataTestChecker.
interface DataChecker {
    void check(Class cls, FieldSpec[] fields);
}
