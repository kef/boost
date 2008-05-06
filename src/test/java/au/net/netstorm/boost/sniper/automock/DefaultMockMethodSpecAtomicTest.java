package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMockMethodSpecAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    FieldSpec returnValue = new DefaultFieldSpec("returnValue", Object.class);
    FieldSpec methodName = new DefaultFieldSpec("methodName", String.class);
    FieldSpec parameters = new DefaultFieldSpec("parameters", Object[].class);
    FieldSpec[] fields = {returnValue, methodName, parameters};
    AtomTestChecker checker;
    Random random;

    public void setUpFixtures() {
        checker = new LooseDataAtomTestChecker(random);
    }

    public void testAtom() {
        checker.checkAtom(DefaultMockMethodSpec.class, fields);
    }
}