package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class LooseDataAtomDemoTest extends InteractionTestCase implements HasFixtures, InjectableTest {
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec NON_DATA_PROPERTY =
            new DefaultFieldSpec("nonImmutable", NonImmutableInterface.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = {STRING_PROPERTY};
    private static final FieldSpec[] COMPLEX_NON_DATA_PROPERTIES = {STRING_PROPERTY, NON_DATA_PROPERTY};
    Provider random;
    AtomTestChecker checker;

    public void setUpFixtures() {
        checker = new LooseDataAtomTestChecker(random);
    }

    public void testGoodAtoms() {
        checkGoodAtom(NullsAreIllegalData.class, SINGLE_STRING_PROPERTY);
        checkGoodAtom(NestedWithNonImmutablePartsIllegalData.class, COMPLEX_NON_DATA_PROPERTIES);
    }

    private void checkGoodAtom(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }
}