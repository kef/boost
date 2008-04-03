package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.core.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultMethodSpec;
import au.net.netstorm.boost.util.introspect.MethodSpec;

// FIX SC600 This looks like it is testing too deep.  Should not it be testing DRMM ONLY.  Sort out DRMM too.
public class DefaultReflectMethodMasterAtomicTest extends BoooostCase {
    private static final String CHURCH_METHOD_NAME = "getSmeetOthEchuRchontIme";
    private static final String FRIDAY_METHOD_NAME = "fridayIsHere";
    private static final String CRAPOLA_METHOD_NAME = "justSomeOldMethod";
    private static final Class[] NO_PARAMETERS = {};
    private static final Class[] CHURCH_PARAMETER_TYPES = {String.class, Map.class};
    private static final Class[] MORE_PARAMETER_TYPES = {String.class, Map.class, List.class};
    private static final Class[] SUBTYPE_PAREMETER_TYPES = new Class[]{String.class, WeakHashMap.class};
    private static final Class[] LESS_PARAMETER_TYPES = {String.class};
    private static final Class[] DIFFERENT_PARAMETER_TYPE = {String.class, Set.class};
    private static final Class INTERFACE_ONE = TestSubjects.TestInterfaceOne.class;
    private static final Class INTERFACE_TWO = TestSubjects.TestInterfaceTwo.class;
    private static final MethodSpec METHOD_CHURCH = new DefaultMethodSpec(CHURCH_METHOD_NAME, CHURCH_PARAMETER_TYPES);
    private static final MethodSpec METHOD_FRIDAY = new DefaultMethodSpec(FRIDAY_METHOD_NAME, NO_PARAMETERS);
    private static final MethodSpec METHOD_CRAPOLA = new DefaultMethodSpec(CRAPOLA_METHOD_NAME, NO_PARAMETERS);
    private static final String[] CHEESE_METHODS = {"getWheels", "getWings", "getSpeed"};
    private final RattysSwissCheese rattysSwissCheese = new DefaultRattysSwissCheese();
    private final ReflectMaster master = new DefaultReflectMaster();
    private final EdgeClass edgeClass = new DefaultEdgeClass();
    private static final boolean NOT_EXACT = false;
    private static final boolean EXACT = true;

    public void testGetMethodBasic() {
        checkWithSameParamTypes(INTERFACE_ONE, METHOD_CHURCH);
        checkWithSameParamTypes(INTERFACE_ONE, METHOD_FRIDAY);
        checkWithSameParamTypes(INTERFACE_TWO, METHOD_CRAPOLA);
    }

    public void testNoMatchingMethod() {
        checkNoMatchingMethod(NOT_EXACT, LESS_PARAMETER_TYPES);
        checkNoMatchingMethod(NOT_EXACT, MORE_PARAMETER_TYPES);
        checkNoMatchingMethod(NOT_EXACT, DIFFERENT_PARAMETER_TYPE);
        checkNoMatchingMethod(EXACT, SUBTYPE_PAREMETER_TYPES);
    }

    public void testGetMethodWithSubtypeParam() {
        Method result = master.getMethod(INTERFACE_ONE, new DefaultMethodSpec(CHURCH_METHOD_NAME, SUBTYPE_PAREMETER_TYPES));
        Method expected = getMethod(INTERFACE_ONE, CHURCH_METHOD_NAME, CHURCH_PARAMETER_TYPES);
        assertEquals(expected, result);
    }

    public void testNullsIllegal() {
        checkNullsIllegal(null, METHOD_CHURCH);
        checkNullsIllegal(String.class, null);
    }

    public void testGetPublicMethodNames() {
        checkGetPublicMethodNames(rattysSwissCheese, CHEESE_METHODS);
    }

    private void checkWithSameParamTypes(Class iface, MethodSpec methodSpec) {
        checkGetMethod(NOT_EXACT, iface, methodSpec);
        checkGetMethod(EXACT, iface, methodSpec);
    }

    private void checkGetPublicMethodNames(Object ref, String[] expected) {
        String[] actual = master.getPublicMethodNames(ref);
        assertEquals(expected, actual);
    }

    private void checkGetMethod(boolean exact, Class cls, MethodSpec method) {
        String name = method.getName();
        Class[] params = method.getParams();
        Method expected = getMethod(cls, name, params);
        if (exact) assertEquals(expected, master.getMethodWithExactParams(cls, method));
        else assertEquals(expected, master.getMethod(cls, method));
    }

    private void checkNullsIllegal(Class cls, MethodSpec method) {
        try {
            master.getMethod(cls, method);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    private void checkNoMatchingMethod(boolean exact, Class[] parameterTypes) {
        MethodSpec methodSpec = new DefaultMethodSpec(CHURCH_METHOD_NAME, parameterTypes);
        try {
            if (exact) master.getMethodWithExactParams(INTERFACE_ONE, methodSpec);
            else master.getMethod(INTERFACE_ONE, methodSpec);
            fail();
        } catch (NoSuchMethodError expected) {
        }
    }

    private Method getMethod(Class cls, String name, Class[] params) {
        return edgeClass.getMethod(cls, name, params);
    }
}