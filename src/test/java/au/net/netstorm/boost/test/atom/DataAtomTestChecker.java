package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataAtomTestChecker {
    void checkAtom(Class cls, FieldSpec[] fields);
}
