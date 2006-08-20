package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.util.introspect.MethodSpec;
import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

// FIX SC600 This looks like it is testing too deep.  Should not it be testing DRMM ONLY.  Sort out DRMM too.
public class DefaultReflectMethodMasterAtomicTest extends TestCase {
    private static final String CHURCH_METHOD_NAME = "getSmeetOthEchuRchontIme";
    private static final String FRIDAY_METHOD_NAME = "fridayIsHere";
    private static final String CRAPOLA_METHOD_NAME = "justSomeOldMethod";
    private static final Class[] CHURCH_PARAMETER_TYPES = new Class[]{String.class, Map.class};
    private static final Class[] MORE_PARAMETER_TYPES = new Class[]{String.class, Map.class, List.class};
    private static final Class[] LESS_PARAMETER_TYPES = new Class[]{String.class};
    private static final Class[] NO_PARAMETERS = new Class[]{};
    private static final Class INTERFACE_ONE = TestSubjects.TestInterfaceOne.class;
    private static final Class INTERFACE_TWO = TestSubjects.TestInterfaceTwo.class;
    private static final MethodSpec METHOD_CHURCH = new MethodSpec(CHURCH_METHOD_NAME, CHURCH_PARAMETER_TYPES);
    private static final MethodSpec METHOD_FRIDAY = new MethodSpec(FRIDAY_METHOD_NAME, NO_PARAMETERS);
    private static final MethodSpec METHOD_CRAPOLA = new MethodSpec(CRAPOLA_METHOD_NAME, NO_PARAMETERS);
    private final ReflectMaster master = new DefaultReflectMaster();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public void testGetMethodBasic() {
        checkGetMethod(INTERFACE_ONE, METHOD_CHURCH);
        checkGetMethod(INTERFACE_ONE, METHOD_FRIDAY);
        checkGetMethod(INTERFACE_TWO, METHOD_CRAPOLA);
    }

    public void testNoMatchingMethod() {
        checkNoMatchingMethod(LESS_PARAMETER_TYPES);
        checkNoMatchingMethod(MORE_PARAMETER_TYPES);
    }

    public void testGetMethodWithSubtypeParam() {
        Class[] params = new Class[]{String.class, WeakHashMap.class};
        Method result = master.getMethod(INTERFACE_ONE, new MethodSpec(CHURCH_METHOD_NAME, params));
        Method expected = getMethod(INTERFACE_ONE, CHURCH_METHOD_NAME, CHURCH_PARAMETER_TYPES);
        assertEquals(expected, result);
    }

    public void testNullsIllegal() {
        checkNullsIllegal(null, METHOD_CHURCH);
        checkNullsIllegal(String.class, null);
    }

    private void checkGetMethod(Class cls, MethodSpec method) {
        String name = method.getName();
        Class[] params = method.getParams();
        Method expected = getMethod(cls, name, params);
        assertEquals(expected, master.getMethod(cls, method));
    }

    private void checkNullsIllegal(Class cls, MethodSpec method) {
        try {
            master.getMethod(cls, method);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void checkNoMatchingMethod(Class[] parameterTypes) {
        MethodSpec methodSpec = new MethodSpec(CHURCH_METHOD_NAME, parameterTypes);
        Class cls = INTERFACE_ONE;
        try {
            master.getMethod(cls, methodSpec);
            fail();
        } catch (NoSuchMethodError expected) { }
    }

    private Method getMethod(Class cls, String name, Class[] params) {
        return edgeClass.getMethod(cls, name, params);
    }
}