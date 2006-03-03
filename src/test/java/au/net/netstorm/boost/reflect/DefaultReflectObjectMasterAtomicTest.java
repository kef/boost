package au.net.netstorm.boost.reflect;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.primordial.PrimordialTestCase;

// FIXME: SC506 This NEEDS to be a UnitTest!!!
// FIXME: SC506 Rename to Atomic test when done
// FIXME: SC502 Rename to Atomic test when done.

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
        } catch (MultipleConstructorsNotSupportedException expected) { }
    }
}
