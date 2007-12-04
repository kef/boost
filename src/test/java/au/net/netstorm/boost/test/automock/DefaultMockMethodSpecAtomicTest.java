package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

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