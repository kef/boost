package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.provider.Provider;

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
