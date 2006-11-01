package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultDataAtomTestChecker implements DataAtomTestChecker {
    private DataAtomTestChecker testChecker = new GenericDataAtomTestChecker();

    public void checkAtom(Class cls, FieldSpec[] fields) {
        testChecker.checkAtom(cls, fields);
    }
}
