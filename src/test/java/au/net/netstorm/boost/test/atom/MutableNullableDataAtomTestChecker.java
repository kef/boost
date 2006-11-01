package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class MutableNullableDataAtomTestChecker implements DataAtomTestChecker {
    private DataAtomTestChecker checker = new GenericDataAtomTestChecker(false, false);

    // FIX 525 Demo test for this guy.
    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
