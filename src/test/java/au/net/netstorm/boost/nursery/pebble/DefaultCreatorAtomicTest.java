package au.net.netstorm.boost.nursery.pebble;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.pebble.pebble.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.pebble.Creator;
import au.net.netstorm.boost.nursery.pebble.pebble.DefaultCreator;
import au.net.netstorm.boost.nursery.pebble.pebble.Implementation;
import au.net.netstorm.boost.nursery.pebble.pebble.Onion;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Creator subject;
    private MockExpectations expect;
    private EdgeClass edgeClass;
    private EdgeConstructor edgeConstructor;
    private Implementation implementation;
    private Interface type;
    private Onion onion;

    // FIX 1665 Should triangulate here, but thinking of moving to stateful Edges.
    private Class cls = HashSet.class;
    private Constructor constructor = HashSet.class.getConstructors()[0];
    private Class[] parameters = new Class[]{};
    private Object concreteObject = new Object();
    private Object concreteWithOnionLayer = new Object();
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void setupSubjects() {
        subject = new DefaultCreator(implementation);
        checkCreationOfInstanceVariables();
        overwriteConstructedInstancesWithMocks();
    }

    public void testCreator() {
        expect.oneCall(implementation, cls, "getImpl");
        expect.oneCall(edgeClass, constructor, "getConstructor", cls, parameters);
        expect.oneCall(edgeConstructor, concreteObject, "newInstance", constructor, parameters);
        expect.oneCall(implementation, type, "getType");
        expect.oneCall(onion, concreteWithOnionLayer, "onionize", concreteObject, type);
        Object result = subject.create(parameters);
        assertEquals(concreteWithOnionLayer, result);
    }

    private void checkCreationOfInstanceVariables() {
        checkConstructedInstanceVariable(subject, "edgeConstructor", DefaultEdgeConstructor.class);
        checkConstructedInstanceVariable(subject, "edgeClass", DefaultEdgeClass.class);
        checkConstructedInstanceVariable(subject, "onion", BermudaOnion.class);
    }

    // FIX 1665 Move this to a TestUtil or have a Wiring test that scoops all these somewhere, somehow...
    private void checkConstructedInstanceVariable(Creator subject, String fieldName, Class implementationClass) {
        Object o = fieldTestUtil.getInstance(subject, fieldName);
        assertNotNull("You must create an instance of " + implementationClass + " for " + fieldName, o);
        assertSame(o.getClass(), implementationClass);
    }

    private void overwriteConstructedInstancesWithMocks() {
        fieldTestUtil.setInstance(subject, "edgeConstructor", edgeConstructor);
        fieldTestUtil.setInstance(subject, "edgeClass", edgeClass);
        fieldTestUtil.setInstance(subject, "onion", onion);
    }
}
