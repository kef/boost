package au.net.netstorm.boost.bullet.primmm;

import au.net.netstorm.boost.gunge.equals.EqualsMaster;
import au.net.netstorm.boost.gunge.equals.MockEqualsMaster;
import au.net.netstorm.boost.gunge.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.tostring.MockToStringMaster;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.nursery.gunge.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.nursery.gunge.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.ModifierTestChecker;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

// FIX SC600 Looks like an integration test. Mock bits Primordial depends on.

// DEBT ClassDataAbstractionCoupling {
public final class PrimordialAtomicTest extends BoooostCase {
    private final ModifierTestChecker modifier = new DefaultModifierTestChecker();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private ToStringMaster origToString;
    private EqualsMaster origEquals;

    {
        origEquals = (EqualsMaster) fielder.getStatic(Primordial.class, "equalsMaster");
        origToString = (ToStringMaster) fielder.getStatic(Primordial.class, "toStringMaster");
    }

    public void testNotAbstract() {
        modifier.checkConcrete(Primordial.class);
    }

    public void testHashCode() {
        Primordial primordial = new Primordial();
        int actual = primordial.hashCode();
        assertEquals(42, actual);
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
        String actual = primordial.toString();
        assertEquals(expected, actual);
        revertToString();
    }

    private void checkField(Class type, String fieldName) {
        Object fieldValue = fielder.getStatic(Primordial.class, fieldName);
        assertNotNull(fieldValue);
        assertEquals(type, fieldValue.getClass());
    }

    private void checkExpectedEquals(boolean expected) {
        MockEqualsMaster mockEquals = createMockEquals(expected);
        Primordial primordial = createPrimordialEquals(mockEquals);
        checkEquals(expected, primordial, mockEquals);
        revertEquals();
    }

    private void checkEquals(boolean expected, Primordial primordial, MockEqualsMaster mockEquals) {
        Object o = new Object();
        boolean result = primordial.equals(o);
        assertEquals(true, primordial == mockEquals.getObject1());
        assertEquals(true, o == mockEquals.getObject2());
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
        return createPrimordialWithStaticField(master, "equalsMaster");
    }

    private Primordial createPrimordialWithToString(ToStringMaster master) {
        return createPrimordialWithStaticField(master, "toStringMaster");
    }

    private Primordial createPrimordialWithStaticField(Object master, String fieldName) {
        FieldValueSpec fieldValue = new DefaultFieldValueSpec(fieldName, master);
        fielder.setStatic(Primordial.class, fieldValue);
        return new Primordial();
    }

    private void revertEquals() {
        fielder.setStatic(Primordial.class, "equalsMaster", origEquals);
    }

    private void revertToString() {
        fielder.setStatic(Primordial.class, "toStringMaster", origToString);
    }
}
// } DEBT ClassDataAbstractionCoupling
