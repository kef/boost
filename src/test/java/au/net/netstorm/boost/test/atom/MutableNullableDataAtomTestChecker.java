package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// SUGGEST: Actually what we really want is the ability to specify whether individual properties are
// SUGGEST: meant to be mutable/nullable or not.
public final class MutableNullableDataAtomTestChecker implements DataAtomTestChecker {
    private DataAtomTestChecker checker = new GenericDataAtomTestChecker(false, false);

    // FIX 525 Demo test for this guy.
    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
