package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.LooseData;

// SUGGEST: Actually what we really want is the ability to specify whether individual properties are

// SUGGEST: meant to be mutable/nullable or not.
public final class LooseDataAtomTestChecker implements AtomTestChecker {
    private AtomConfiguration config = new DefaultAtomConfiguration(LooseData.class);
    private AtomTestChecker checker;

    public LooseDataAtomTestChecker(SpecificProviderRegistry specifics) {
        checker = new GenericAtomTestChecker(config, specifics);
    }

    public void checkAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}
