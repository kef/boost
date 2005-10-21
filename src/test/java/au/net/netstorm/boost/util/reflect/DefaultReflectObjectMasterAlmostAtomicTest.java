package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.introspect.CallSpec;
import au.net.netstorm.boost.primordial.PrimordialTestCase;

// FIXME: SC501 This NEEDS to be a UnitTest!!!
// FIXME: SC501 Rename this to DROMAlmostAtomicTest.
public class DefaultReflectObjectMasterAlmostAtomicTest extends PrimordialTestCase {
    private final ReflectObjectMaster master = new DefaultReflectObjectMaster();

    // FIXME: SC501 Uncomment lines below.
//    public void testPrivateConstructorRequired() {
//        checkPrivateConstructorRequired(TestSubjects.TestNoPrivateConstructor.class);
//        checkPrivateConstructorRequired(DefaultUuid.class);
//        master.create(Primordial.class);
//        master.create(AxisEasyDocPort.class);
//    }
//
    // FIXME: SC501 Reinstate.
//    public void testPrivateConstructorRelaxed() {
//        master.create(Primordial.class);
//    }

    public void testCreateObjectWithPrivateConstructor() {
        Object result = master.create(TestSubjects.TestSinglePrivateConstructor.class);
        assertTrue(TestSubjects.TestSinglePrivateConstructor.class.isAssignableFrom(result.getClass()));
    }

    public void testCreateFailsWithMultipleConstructors() {
        checkCreateFailsWithMultipleConstructors(TestSubjects.TEST_TWO_CONSTRUCTORS);
        checkCreateFailsWithMultipleConstructors(TestSubjects.TestThreeConstructors.class);
    }

    public void failToCreateWithInterfaces() throws UnsupportedOperationException {
        master.create(TestSubjects.TEST_INTERFACE_ONE);
    }

    private void checkPrivateConstructorRequired(Class impl) {
        CallSpec spec = new CallSpec("create", new Class[]{Class.class}, new Object[]{impl});
// FIXME: SC501 Replace with standard exception test block.
//        ThrowAssert.assertThrows(ConstructorNotPrivateException.class, master, spec);
    }

    private void checkCreateFailsWithMultipleConstructors(Class cls) {
        CallSpec spec = new CallSpec("create", new Class[]{Class.class}, new Object[]{cls});
// FIXME: SC501 Replace with standard exception test block.
//        ThrowAssert.assertThrows(MultipleConstructorsNotSupportedException.class, master, spec);
    }
}
