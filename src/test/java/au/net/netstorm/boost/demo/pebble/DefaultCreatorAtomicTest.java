package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultCreatorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Creator subject;
    private MockExpectations expect;
    // FIX BREADCRUMB 1665 Look
    private Object expectedObject = "";
    private EdgeConstructor edgeConstructor;
    private Implementation implementation;
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void testCreator() {
        Class[] parameters = new Class[]{};
        Object actualObject = subject.create(parameters);
        expectEdgeConstructorToBeCalled();
        assertEquals(expectedObject, actualObject);
        // FIX BREADCRUMB 1665 -10000 Pass in an implementation reference.
    }

    private void expectEdgeConstructorToBeCalled() {
    
    }

    public void setupSubjects() {
        subject = new DefaultCreator(implementation);
        fieldTestUtil.setInstance(subject, "edgeConstructor", edgeConstructor);
    }
}
