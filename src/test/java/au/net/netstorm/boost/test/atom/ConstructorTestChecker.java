package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface ConstructorTestChecker {
    void checkMatches(Class cls, FieldSpec[] fields);
}
