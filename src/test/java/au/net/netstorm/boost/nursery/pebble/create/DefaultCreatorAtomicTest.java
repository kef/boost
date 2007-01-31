package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultCreatorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Creator subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator instantiator;
    private Object[] parameters = { "Hi", "There" };
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void setupSubjects() {
        subject = new DefaultCreator();
        checkCreationOfInstanceVariables();
        overwriteConstructedInstancesWithMocks();
    }

    public void testCreator() {
        expect.oneCall(instantiator, rawRef, "instantiate", type, parameters);
        expect.oneCall(onion, wrappedRef, "onionize", rawRef);
        Object result = subject.create(type, parameters);
        assertEquals(wrappedRef, result);
    }

    private void checkCreationOfInstanceVariables() {
        checkConstructedInstanceVariable(subject, "instantiator", SingleConstructorBasedInjectionInstantiator.class);
        checkConstructedInstanceVariable(subject, "onion", BermudaOnion.class);
    }

    // FIX 1665 Move this to a TestUtil or have a Wiring test that scoops all these somewhere, somehow...
    private void checkConstructedInstanceVariable(Creator subject, String fieldName, Class implementationClass) {
        Object o = fieldTestUtil.getInstance(subject, fieldName);
        assertNotNull("You must create an instance of " + implementationClass + " for " + fieldName, o);
        assertSame(o.getClass(), implementationClass);
    }

    private void overwriteConstructedInstancesWithMocks() {
        fieldTestUtil.setInstance(subject, "instantiator", instantiator);
        fieldTestUtil.setInstance(subject, "onion", onion);
    }
}
