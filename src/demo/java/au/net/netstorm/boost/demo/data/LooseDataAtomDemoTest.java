package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class LooseDataAtomDemoTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec NON_DATA_PROPERTY =
            new DefaultFieldSpec("nonImmutable", NonImmutableInterface.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = {STRING_PROPERTY};
    private static final FieldSpec[] COMPLEX_NON_DATA_PROPERTIES = {STRING_PROPERTY, NON_DATA_PROPERTY};
    Random random;
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