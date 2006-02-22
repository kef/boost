package au.net.netstorm.boost.primordial;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

import junit.framework.TestCase;

import au.net.netstorm.boost.util.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.util.equals.EqualsMaster;
import au.net.netstorm.boost.util.reflect.DefaultClassPropertiesTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.reflect.DefaultReflectTestUtil;
import au.net.netstorm.boost.util.tostring.ToStringMaster;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;

public final class PrimordialAtomicTest extends TestCase {
    private final ReflectTestUtil reflector = new DefaultReflectTestUtil();
    private final ClassPropertiesTestUtil clsProperties = new DefaultClassPropertiesTestUtil();

    public void testNotAbstract() {
        assertFalse(clsProperties.isAbstract(Primordial.class));
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
        String expected = "An honest finally reaped what he had sown, and a farmer in Ohio has just repaid his loan.";
        MockToStringMaster mockToString = createMockToString(expected);
        Primordial primordial = createPrimordialWithToString(mockToString);
        assertEquals(expected, primordial.toString());
    }

    private void checkField(final Class type, final String fieldName) {
        Object fieldValue = reflector.getInstanceField(new Primordial(), fieldName);
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
        resolveField(primordial, fieldValue);
        return primordial;
    }

    // FIXME: SC502 Move out into shared class.
    public static void resolveField(Object ref, FieldValueSpec fieldValue) {
        Class cls = ref.getClass();
        try {
            Field field = cls.getDeclaredField(fieldValue.getName());
            field.setAccessible(true);
            field.set(ref, fieldValue.getValue());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e); // FIXME: SC502 Push out to "edge".
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkMethodFinal(String methodName, Class[] parameterTypes) {
        Method method = ReflectEdge.INSTANCE.getMethod(Primordial.class, methodName, parameterTypes);
        assertTrue(clsProperties.isMethodFinal(method));
    }
}
