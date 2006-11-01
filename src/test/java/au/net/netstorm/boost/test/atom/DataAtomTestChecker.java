package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;

public final class DataAtomTestChecker implements AtomTestChecker {
    private AtomConfiguration config = new DefaultAtomConfiguration(Data.class);
    private AtomTestChecker checker = new GenericAtomTestChecker(config);

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
