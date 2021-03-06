package au.net.netstorm.boost.bullet.splitter;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.MethodTestUtil;

// FIX SC600 List/Map needs to be weak reference.
// FIX SC600 Too complicated.  Simplify.

// DEBT ClassDataAbstractionCoupling {
public final class DefaultOneToManyAtomicTest extends BoooostCase {
    private static final int ZERO_LISTENERS = 0;
    private static final int SINGLE_LISTENER = 1;
    private static final int TWENTY_LISTENERS = 20;
    private static final Interface INTERFACE_ONE = new DefaultInterface(TestInterfaceOne.class);
    private static final Interface INTERFACE_TWO = new DefaultInterface(TestInterfaceTwo.class);
    private static final Interface INTERFACE_THREE = new DefaultInterface(TestInterfaceThree.class);
    private static final String STRING = "Hello";
    private static final Integer INTEGER = 7;
    private static final Object[] NO_PARAMETERS = {};
    private static final Object[] METHOD_ONE_PARAMETERS = {STRING};
    private static final Object[] METHOD_TWO_PARAMETERS = {INTEGER, INTEGER};
    private static final NumberFormatException AN_EXCEPTION = new NumberFormatException();
    private final MethodTestUtil methods = new DefaultMethodTestUtil();
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final List mockListeners = new ArrayList();
    private OneToMany oneToMany;

    public void testInvoke() {
        checkInvoke(ZERO_LISTENERS);
        checkInvoke(SINGLE_LISTENER);
        checkInvoke(TWENTY_LISTENERS);
    }

    public void testSynchronized() {
        clsChecker.checkSynchronized(DefaultOneToMany.class);
    }

    public void testNullsIllegalInConstructor() {
        try {
            new DefaultOneToMany(null);
            fail();
        } catch (Exception expected) {
        }
    }

    public void testNullIllegal() {
        OneToMany oneToMany = new DefaultOneToMany(INTERFACE_ONE);
        try {
            oneToMany.add(null);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    public void testExceptionsAreExtractedFromInvocationTargetException() {
        oneToMany = new DefaultOneToMany(INTERFACE_THREE);
        MockTestInterfaceThree mockMany = new MockTestInterfaceThree();
        mockMany.init(AN_EXCEPTION);
        oneToMany.add(mockMany);
        TestInterfaceThree one = (TestInterfaceThree) oneToMany.getOne();
        checkException(AN_EXCEPTION, one);
    }

    private void checkInvoke(int listenerCount) {
        checkInvoke(listenerCount, INTERFACE_ONE, "method", NO_PARAMETERS);
        checkInvoke(listenerCount, INTERFACE_TWO, "methodOne", METHOD_ONE_PARAMETERS);
        checkInvoke(listenerCount, INTERFACE_TWO, "methodTwo", METHOD_TWO_PARAMETERS);
    }

    private void checkInvoke(int listenerCount, Interface type, String methodName, Object[] parameters) {
        oneToMany = new DefaultOneToMany(type);
        createMany(listenerCount, type, methodName, parameters);
        performAndCheckCalls(type, methodName, parameters);
    }

    private void checkException(Exception expected, TestInterfaceThree one) {
        try {
            one.barf();
            fail();
        } catch (NumberFormatException e) {
            assertSame(expected, e);
        }
    }

    private void createMany(int listenerCount, Interface type, String methodName, Object[] parameters) {
        mockListeners.clear();
        for (int i = ZERO_LISTENERS; i < listenerCount; i++) {
            createListener(type, methodName, parameters);
        }
    }

    private void performAndCheckCalls(Interface type, String methodName, Object[] parameters) {
        Object one = getOne(type);
        methods.invoke(one, methodName, parameters);
        checkListenerCall(SINGLE_LISTENER, methodName);
        methods.invoke(one, methodName, parameters);
        methods.invoke(one, methodName, parameters);
        checkListenerCall(3, methodName);
    }

    private void checkListenerCall(int expectedCount, String methodName) {
        for (int i = ZERO_LISTENERS; i < mockListeners.size(); i++) {
            MockListener mockListener = (MockListener) mockListeners.get(i);
            mockListener.checkCallCount(methodName, expectedCount);
        }
    }

    private void createListener(Interface type, String methodName, Object[] parameters) {
        MockListener mockListener = createMockImpl(type, methodName, parameters);
        mockListeners.add(mockListener);
        Object listener = mockListener.getRef();
        oneToMany.add(listener);
    }

    private Object getOne(Interface type) {
        Object one = oneToMany.getOne();
        checkProxyType(type, one);
        return one;
    }

    private MockListener createMockImpl(Interface face, String methodName, Object[] parameters) {
        MockListener mockImpl = new MockListener(face);
        mockImpl.setExpectation(methodName, parameters);
        return mockImpl;
    }

    private void checkProxyType(Interface expectedInterface, Object ref) {
        assertEquals(true, expectedInterface.getType().isAssignableFrom(ref.getClass()));
    }
}
// } DEBT ClassDataAbstractionCoupling
