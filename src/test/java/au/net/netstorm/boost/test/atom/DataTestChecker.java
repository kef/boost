package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataTestChecker {
    void checkIsData(Class cls, FieldSpec[] fields);
}
