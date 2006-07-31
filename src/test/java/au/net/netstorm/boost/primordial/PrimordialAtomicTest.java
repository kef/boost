package au.net.netstorm.boost.primordial;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeReflect;
import au.net.netstorm.boost.edge.java.lang.reflect.OldEdgeReflect;
import au.net.netstorm.boost.test.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.checker.ModifierTestChecker;
import au.net.netstorm.boost.test.reflect.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.FieldTestUtil;
import au.net.netstorm.boost.util.equals.EqualsMaster;
import au.net.netstorm.boost.util.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;
import junit.framework.TestCase;

// FIXME: SC043 Looks like an integration test. Mock bits Primordial depends on.

public final class PrimordialAtomicTest extends TestCase {
    private final ModifierTestChecker modifier = new DefaultModifierTestChecker();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final EdgeReflect reflector = new OldEdgeReflect();

    public void testNotAbstract() {
        modifier.checkConcrete(Primordial.class);
    }

    public void testMethodsFinal() {
        checkMethodFinal("toString", new Class[]{});
        checkMethodFinal("equals", new Class[]{Object.class});
    }

    public void testHashCode() {
        assertEquals(42, new Primordial().hashCode());
    }

    public void testEqualsMaster() {
        checkField(FieldBasedEqualsMaster.class, "equalsMaster");
    }

    public void testEqualsTriangulation() {
        checkExpectedEquals(true);
        checkExpectedEquals(false);
    }

    public void testToStringMaster() {
        checkField(IndentingToStringMaster.class, "toStringMaster");
    }

    public void testToString() {
        String expected = "An honest man finally reaped what he had sown, and a farmer in Ohio has just repaid his loan.";
        MockToStringMaster mockToString = createMockToString(expected);
        Primordial primordial = createPrimordialWithToString(mockToString);
        assertEquals(expected, primordial.toString());
    }

    private void checkField(final Class type, final String fieldName) {
        Object fieldValue = fielder.getInstance(new Primordial(), fieldName);
        assertNotNull(fieldValue);
        assertEquals(type, fieldValue.getClass());
    }

    private void checkExpectedEquals(boolean expected) {
        MockEqualsMaster mockEquals = createMockEquals(expected);
        Primordial primordial = createPrimordialEquals(mockEquals);
        checkEquals(expected, primordial, mockEquals);
    }

    private void checkEquals(boolean expected, Primordial primordial, MockEqualsMaster mockEquals) {
        Object o = new Object();
        boolean result = primordial.equals(o);
        assertTrue(primordial == mockEquals.getObject1());
        assertTrue(o == mockEquals.getObject2());
        assertEquals(expected, result);
    }

    private MockEqualsMaster createMockEquals(boolean expected) {
        MockEqualsMaster mockEquals = new MockEqualsMaster();
        mockEquals.prepare(expected);
        return mockEquals;
    }

    private MockToStringMaster createMockToString(String expected) {
        MockToStringMaster mockToString = new MockToStringMaster();
        mockToString.prepare(expected);
        return mockToString;
    }

    private Primordial createPrimordialEquals(EqualsMaster master) {
        return createPrimordialWithField(master, "equalsMaster");
    }

    private Primordial createPrimordialWithToString(ToStringMaster master) {
        return createPrimordialWithField(master, "toStringMaster");
    }

    private Primordial createPrimordialWithField(Object master, String fieldName) {
        Primordial primordial = new Primordial();
        FieldValueSpec fieldValue = new DefaultFieldValueSpec(fieldName, master);
        fielder.setInstance(primordial, fieldValue);
        return primordial;
    }

    private void checkMethodFinal(String methodName, Class[] parameterTypes) {
        Method method = reflector.getMethod(Primordial.class, methodName, parameterTypes);
        modifier.checkFinal(method);
    }
}
