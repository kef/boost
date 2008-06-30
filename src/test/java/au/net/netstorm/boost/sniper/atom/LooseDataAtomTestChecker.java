package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.type.LooseData;
import au.net.netstorm.boost.gunge.provider.Provider;

// SUGGEST: Actually what we really want is the ability to specify whether individual properties are

// SUGGEST: meant to be mutable/nullable or not.
public final class LooseDataAtomTestChecker implements AtomTestChecker {
    private AtomConfiguration config = new DefaultAtomConfiguration(LooseData.class);
    private AtomTestChecker checker;

    public LooseDataAtomTestChecker(Provider random) {
        checker = new GenericAtomTestChecker(config, random);
    }

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
