package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;

public final class DataAtomTestChecker implements AtomTestChecker {
    private AtomConfiguration config = new DefaultAtomConfiguration(Data.class);
    private AtomTestChecker checker;

    public DataAtomTestChecker(Provider random) {
        checker = new GenericAtomTestChecker(config, random);
    }

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
