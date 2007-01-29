package au.net.netstorm.boost.demo.pebble;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
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

    public void testCreator() {
        expect.oneCall(implementation, cls, "getImpl");
        expect.oneCall(edgeClass, constructor, "getConstructor", cls, parameters);
        expect.oneCall(edgeConstructor, concreteObject, "newInstance", constructor, parameters);
        expect.oneCall(implementation, type, "getType");
        expect.oneCall(onion, concreteWithOnionLayer, "onionize", concreteObject, type);
        Object result = subject.create(parameters);
        assertEquals(concreteWithOnionLayer, result);
    }

    public void setupSubjects() {
        // FIX 1665 Remove onion from the constructor
        subject = new DefaultCreator(implementation, onion);
        fieldTestUtil.setInstance(subject, "edgeConstructor", edgeConstructor);
        fieldTestUtil.setInstance(subject, "edgeClass", edgeClass);
    }
}
