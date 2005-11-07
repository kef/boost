package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.ioc.MultipleConstructorsNotSupportedException;
import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.introspect.CallSpec;

// FIXME: SC506 This NEEDS to be a UnitTest!!!
// FIXME: SC506 Rename to Atomic test when done
// FIXME: SC502 Rename to Atomic test when done.

public class DefaultReflectObjectMasterAlmostAtomicTest extends PrimordialTestCase {
    private final ReflectObjectMaster master = new DefaultReflectObjectMaster();

    public void testFailsWithMultipleConstructors() {
        checkFailsWithMultipleConstructors(TestSubjects.TestTwoConstructors.class);
        checkFailsWithMultipleConstructors(TestSubjects.TestThreeConstructors.class);
    }

    public void testSingleConstructor() {
        Class cls = TestSubjects.TestOneConstructor.class;
        checkSingleConstructor(cls);
        // FIXME: SC502 Check private constructor.
    }

    public void testCreateFailsWithMultipleConstructors() {
        checkCreateFailsWithMultipleConstructors(TestSubjects.TEST_TWO_CONSTRUCTORS);
        checkCreateFailsWithMultipleConstructors(TestSubjects.TestThreeConstructors.class);
    }

    public void failToCreateWithInterfaces() throws UnsupportedOperationException {
        // FIXME: SC502 Reinstate if required.
//        master.create(TestSubjects.TEST_INTERFACE_ONE);
    }

    private void checkSingleConstructor(Class cls) {
        Constructor constructor = master.getConstructor(cls);
        Constructor[] constructors = cls.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        assertEquals(constructors[0], constructor);
    }

    private void checkFailsWithMultipleConstructors(Class cls) {
        try {
            master.getConstructor(cls);
            fail();
        } catch (MultipleConstructorsNotSupportedException expected) { }
    }

    private void checkCreateFailsWithMultipleConstructors(Class cls) {
        CallSpec spec = new CallSpec("create", new Class[]{Class.class}, new Object[]{cls});
// FIXME: SC506 Replace with standard exception test block.
//        ThrowAssert.assertThrows(MultipleConstructorsNotSupportedException.class, master, spec);
    }
}
