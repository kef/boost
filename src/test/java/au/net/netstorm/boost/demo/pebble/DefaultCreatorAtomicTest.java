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
    // FIX BREADCRUMB 1665 Look
    private EdgeClass edgeClass;
    private EdgeConstructor edgeConstructor;
    // FIX 1665 Should triangulate here, but thinking of moving to stateful Edges.
    private Class cls = HashSet.class;
    private Implementation implementation;
    private Interface type;
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();
    private Constructor constructor = HashSet.class.getConstructors()[0];
    private Class[] parameters = new Class[]{};
    private Object ref = new Object();
    private Object wrapped = new Object();

    public void testCreator() {
        expect.oneCall(implementation, cls, "getImpl");
        expect.oneCall(edgeClass, constructor, "getConstructor", cls, parameters);
        expect.oneCall(edgeConstructor, ref, "newInstance", constructor, parameters);
        expect.oneCall(implementation, type, "getType");
        Object result = subject.create(parameters);
//        assertEquals(wrapped, result);
        // FIX BREADCRUMB 1665 -10000 Pass in an implementation reference.
    }

    public void setupSubjects() {
        subject = new DefaultCreator(implementation);
        fieldTestUtil.setInstance(subject, "edgeConstructor", edgeConstructor);
        fieldTestUtil.setInstance(subject, "edgeClass", edgeClass);
    }
}
