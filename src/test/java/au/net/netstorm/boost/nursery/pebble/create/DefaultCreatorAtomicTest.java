package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldInstantiationChecker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldInstantiationChecker;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// FIX 1665 Pass in dependencies.
public final class DefaultCreatorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Creator subject;
    private MockExpectations expect;
    private Onion onion;
    private Instantiator instantiator;
    private Object[] parameters = {"Hi", "There"};
    private Class type = String.class;
    private Object rawRef = new Object();
    private Object wrappedRef = new Object();
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();
    private FieldInstantiationChecker fieldInstantiationChecker = new DefaultFieldInstantiationChecker();

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
        fieldInstantiationChecker.check(subject, "instantiator", SingleConstructorBasedInjectionInstantiator.class);
        fieldInstantiationChecker.check(subject, "onion", BermudaOnion.class);
    }

    private void overwriteConstructedInstancesWithMocks() {
        fieldTestUtil.setInstance(subject, "instantiator", instantiator);
        fieldTestUtil.setInstance(subject, "onion", onion);
    }
}
