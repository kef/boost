package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredInterfaceAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    FieldSpec f1 = new DefaultFieldSpec("iface", Interface.class);
    FieldSpec f2 = new DefaultFieldSpec("flavour", Flavour.class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker;
    Interface iface;
    Flavour flavour;

    public void testAtom() {
        checker.checkAtom(DefaultFlavouredInterface.class, fields);
    }

    public void testFastHashCode() {
        FlavouredInterface subject = new DefaultFlavouredInterface(iface, flavour);
        int actual = subject.hashCode();
        int expected = iface.hashCode();
        assertEquals(expected, actual);
    }
}
