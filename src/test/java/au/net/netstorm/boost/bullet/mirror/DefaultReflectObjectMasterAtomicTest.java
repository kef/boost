package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sniper.core.BoooostCase;

public class DefaultReflectObjectMasterAtomicTest extends BoooostCase {
    private final ReflectObjectMaster master = new DefaultReflectObjectMaster();
    private final ReflectMaster delegate = new DefaultReflectMaster();

    public void testWithImpl() {
        Class<TestSubjects.TestOneConstructor> cls = TestSubjects.TestOneConstructor.class;
        Implementation impl = new DefaultImplementation(cls);
        Constructor constructor = master.getConstructor(impl);
        checkSingleConstructor(cls, constructor);
    }

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
        checkRaw(cls, master);
        checkRaw(cls, master);
        checkStrongType(cls, delegate);
        checkStrongType(cls, delegate);
    }

    private void checkRaw(Class cls, ReflectObjectMaster subject) {
        Constructor constructor = subject.getConstructor(cls);
        checkSingleConstructor(cls, constructor);
    }

    private void checkStrongType(Class cls, ReflectObjectMaster subject) {
        Implementation impl = new DefaultImplementation(cls);
        Constructor constructor = subject.getConstructor(impl);
        checkSingleConstructor(cls, constructor);
    }

    private void checkSingleConstructor(Class<TestSubjects.TestOneConstructor> cls, Constructor constructor) {
        Constructor[] constructors = cls.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        assertEquals(constructors[0], constructor);
    }

    private void checkFailsWithMultipleConstructors(Class cls) {
        try {
            master.getConstructor(cls);
            fail();
        } catch (IllegalStateException expected) {}
    }
}
