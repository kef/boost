package au.net.netstorm.boost.listener;

import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.reflect.ReflectionTestUtil;
import junit.framework.TestCase;

// FIXME: SC501 List/Map needs to be weak reference.
// FIXME: SC501 Implement remove(Object o).
// FIXME: SC501 Check fails with nulls to add/remove.
// FIXME: SC501 Methods on interface must all be void return.
// FIXME: SC501 Create ListenerInterface which ensures all methods are void.
public final class DefaultOneToManyAtomicTest extends TestCase
{
    private static final int ZERO_LISTENERS = 0;
    private static final int SINGLE_LISTENER = 1;
    private static final int TWENTY_LISTENERS = 20;
    private static final Interface INTERFACE_ONE = new Interface(TestInterfaceOne.class);
    private static final Interface INTERFACE_TWO = new Interface(TestInterfaceTwo.class);
    private static final String STRING = "Hello";
    private static final Integer INTEGER = new Integer(7);
    private static final Object[] NO_PARAMETERS = {};
    private static final Object[] METHOD_ONE_PARAMETERS = {STRING};
    private static final Object[] METHOD_TWO_PARAMETERS = {INTEGER, INTEGER};

    private final ReflectionTestUtil reflector = ReflectionTestUtil.INSTANCE;
    private final List mockListeners = new ArrayList();
    private OneToMany oneToMany;

    public void testInvoke()
    {
        checkInvoke(ZERO_LISTENERS);
        checkInvoke(SINGLE_LISTENER);
        checkInvoke(TWENTY_LISTENERS);
    }

    public void testSynchronized()
    {
        reflector.checkSynchronized(DefaultOneToMany.class);
    }

    public void testNullsIllegalInConstructor()
    {
        try
        {
            new DefaultOneToMany(null);
            fail();
        }
        catch (Exception expected)
        {
        }
    }

    public void testNullIllegal()
    {
        OneToMany oneToMany = new DefaultOneToMany(INTERFACE_ONE);
        try
        {
            oneToMany.add(null);
            fail();
        }
        catch (IllegalArgumentException expected)
        {
        }
    }

    private void checkInvoke(int listenerCount)
    {
        checkInvoke(listenerCount, INTERFACE_ONE, "method", NO_PARAMETERS);
        checkInvoke(listenerCount, INTERFACE_TWO, "methodOne", METHOD_ONE_PARAMETERS);
        checkInvoke(listenerCount, INTERFACE_TWO, "methodTwo", METHOD_TWO_PARAMETERS);
    }

    private void checkInvoke(int listenerCount, Interface type, String methodName, Object[] parameters)
    {
        oneToMany = new DefaultOneToMany(type);
        createMany(listenerCount, type, methodName, parameters);
        checkCalls(type, methodName, parameters);
    }

    private void createMany(int listenerCount, Interface type, String methodName, Object[] parameters)
    {
        mockListeners.clear();
        for (int i = ZERO_LISTENERS; i < listenerCount; i++)
        {
            createListener(type, methodName, parameters);
        }
    }

    private void checkCalls(Interface type, String methodName, Object[] parameters)
    {
        Object one = getOne(type);
        reflector.invoke(one, methodName, parameters);
        checkListenerCall(SINGLE_LISTENER, methodName);
        reflector.invoke(one, methodName, parameters);
        reflector.invoke(one, methodName, parameters);
        checkListenerCall(3, methodName);
    }

    private void checkListenerCall(int expectedCount, String methodName)
    {
        for (int i = ZERO_LISTENERS; i < mockListeners.size(); i++)
        {
            MockListener mockListener = (MockListener) mockListeners.get(i);
            mockListener.checkCallCount(methodName, expectedCount);
        }
    }

    private void createListener(Interface type, String methodName, Object[] parameters)
    {
        MockListener mockListener = createMockImpl(type, methodName, parameters);
        mockListeners.add(mockListener);
        Object listener = mockListener.getRef();
        oneToMany.add(listener);
    }

    private Object getOne(Interface type)
    {
        Object one = oneToMany.getOne();
        checkProxyType(type, one);
        return one;
    }

    private MockListener createMockImpl(Interface face, String methodName, Object[] parameters)
    {
        MockListener mockImpl = new MockListener(face);
        mockImpl.setExpectation(methodName, parameters);
        return mockImpl;
    }

    private void checkProxyType(Interface expectedInterface, Object ref)
    {
        assertTrue(expectedInterface.getType().isAssignableFrom(ref.getClass()));
    }
}