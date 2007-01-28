package au.net.netstorm.boost.reflect;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.test.atom.PrimordialTestCase;

public class DefaultReflectObjectMasterAtomicTest extends PrimordialTestCase {
    private final ReflectObjectMaster master = new DefaultReflectObjectMaster();

    public void testFailsWithMultipleConstructors() {
        checkFailsWithMultipleConstructors(TestSubjects.TestTwoConstructors.class);
        checkFailsWithMultipleConstructors(TestSubjects.TestThreeConstructors.class);
    }

    public void testSingleConstructor() {
        checkSingleConstructor(TestSubjects.TestOneConstructor.class);
        checkSingleConstructor(TestSubjects.TestOnePrivateConstructor.class);
    }

    public void testFailsWithInterfaces() {
        try {
            master.getConstructor(TestSubjects.TestInterfaceOne.class);
        } catch (InterfaceNotClassException expected) {
        }
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
        } catch (IllegalStateException expected) {
        }
    }
}
