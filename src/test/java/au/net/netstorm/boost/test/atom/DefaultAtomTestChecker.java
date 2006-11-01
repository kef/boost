package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultAtomTestChecker implements AtomTestChecker {
    private AtomTestChecker checker = new GenericAtomTestChecker(true, true);

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
