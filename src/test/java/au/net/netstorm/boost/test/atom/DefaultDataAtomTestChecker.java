package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultDataAtomTestChecker implements DataAtomTestChecker {
    private DataAtomTestChecker checker = new GenericDataAtomTestChecker(true, true);

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
