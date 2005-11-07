package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.introspect.CallSpec;
import au.net.netstorm.boost.primordial.PrimordialTestCase;

// FIXME: SC506 This NEEDS to be a UnitTest!!!
// FIXME: SC506 Rename to Atomic test when done
// FIXME: SC502 Rename to Atomic test when done.
public class DefaultReflectObjectMasterAlmostAtomicTest extends PrimordialTestCase {
    private final ReflectObjectMaster master = new DefaultReflectObjectMaster();

    public void testCreateFailsWithMultipleConstructors() {
        checkCreateFailsWithMultipleConstructors(TestSubjects.TEST_TWO_CONSTRUCTORS);
        checkCreateFailsWithMultipleConstructors(TestSubjects.TestThreeConstructors.class);
    }

    public void failToCreateWithInterfaces() throws UnsupportedOperationException {
        // FIXME: SC502 Reinstate if required.
//        master.create(TestSubjects.TEST_INTERFACE_ONE);
    }


    private void checkCreateFailsWithMultipleConstructors(Class cls) {
        CallSpec spec = new CallSpec("create", new Class[]{Class.class}, new Object[]{cls});
// FIXME: SC506 Replace with standard exception test block.
//        ThrowAssert.assertThrows(MultipleConstructorsNotSupportedException.class, master, spec);
    }
}
