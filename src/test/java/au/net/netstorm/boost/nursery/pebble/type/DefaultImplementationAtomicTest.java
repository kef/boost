package au.net.netstorm.boost.nursery.pebble.type;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.atom.AtomConfiguration;
import au.net.netstorm.boost.test.atom.AtomStructureChecker;
import au.net.netstorm.boost.test.atom.ConstructorNullDataChecker;
import au.net.netstorm.boost.test.atom.DataChecker;
import au.net.netstorm.boost.test.atom.DefaultAtomConfiguration;
import au.net.netstorm.boost.test.atom.GenericAtomStructureChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultImplementationAtomicTest extends TestCase {
    private static final int FIRST_ELEMENT = 0;
    private static final Class SET_CLASS = Set.class;
    private AtomConfiguration config = new DefaultAtomConfiguration(Data.class);
    private AtomStructureChecker structureChecker = new GenericAtomStructureChecker(config);
    private DataChecker nullChecker = new ConstructorNullDataChecker();

    private Class cls = DefaultImplementation.class;
    private FieldSpec f1 = new DefaultFieldSpec("types", Interface[].class);
    private FieldSpec f2 = new DefaultFieldSpec("impl", Class.class);
    private FieldSpec[] fields = {f1, f2};

    public void testDataAtom() {
        structureChecker.checkStructure(cls, fields);
        nullChecker.check(cls, fields);
    }

    public void testConstructorAndGetters() {
        checkConstructorAndGetters(String.class, CharSequence.class);
        checkConstructorAndGetters(HashSet.class, Set.class);
    }

    public void testConstructorBarfWithInvalidInterfaces() {
        checkConstructorBarfs(new Class[]{CharSequence.class}, Integer.class, FIRST_ELEMENT);
        checkConstructorBarfs(new Class[]{CharSequence.class, SET_CLASS}, String.class, 1);
    }

    private void checkConstructorAndGetters(Class impl, Class type) {
        Interface[] interfaces = createInterfaces(new Class[]{type});
        Implementation subject = new DefaultImplementation(interfaces, impl);
        checkGetImpl(subject, impl);
        checkGetTypes(subject.getTypes()[FIRST_ELEMENT], interfaces[FIRST_ELEMENT]);
    }

    private void checkGetTypes(Interface expectedInterface, Interface actualInterface) {
        assertEquals(expectedInterface.getType(), actualInterface.getType());
    }

    private void checkGetImpl(Implementation subject, Class impl) {
        Class actualImpl = subject.getImpl();
        assertEquals(impl, actualImpl);
    }

    private void checkConstructorBarfs(Class[] interfaceClasses, Class impl, int failingTypePos) {
        Interface[] interfaces = createInterfaces(interfaceClasses);
        checkNonImplementingTypeBarfs(impl, interfaces, failingTypePos);
    }

    private void checkNonImplementingTypeBarfs(Class implClass, Interface[] types, int failingTypePos) {
        try {
            new DefaultImplementation(types, implClass);
            fail();
        } catch (IllegalArgumentException actual) {
            Class notImplClass = types[failingTypePos].getType();
            checkInvalidInterfaceMessage(implClass, actual, notImplClass);
        }
    }

    private void checkInvalidInterfaceMessage(Class implClass, IllegalArgumentException actual, Class type) {
        assertEquals("The interface " + implClass.getName() +
                " does not implement " + type.getName(), actual.getMessage());
    }

    private Interface[] createInterfaces(Class[] interfaceClasses) {
        int length = interfaceClasses.length;
        Interface[] ifaces = new Interface[length];
        for (int i = FIRST_ELEMENT; i < length; i++) {
            Class interfaceClass = interfaceClasses[i];
            Interface nonMatchingInterface = new DefaultInterface(interfaceClass);
            ifaces[i] = nonMatchingInterface;
        }
        return ifaces;
    }
}
