package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.scalpel.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.scalpel.testdata.edge.ArrayElement;
import au.net.netstorm.boost.scalpel.testdata.real.Arrayo;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

import java.nio.ByteBuffer;

public final class DefaultReturnEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Method bufferEdge;
    private Method streamEdge;
    private Method arrayoSingleEdge;
    private Method arrayoRealEdge;
    private Method arrayoMultiEdge;
    private ReturnEdger subject;
    private ByteBuffer bufferDummy;
    StreamFixture stream;
    ArrayoFixture arrayo;
    AutoEdger edgerMock;
    AutoEdgeByteBuffer bufferMock;
    EdgeClass classer;
    ArrayElement elementMock;

    public void setUpFixtures() {
        subject = new DefaultReturnEdger();
        bufferEdge = method();
        streamEdge = stream.edgeMethod();
        arrayoSingleEdge = arrayo.edgedSingle();
        arrayoRealEdge = arrayo.edgedReal();
        arrayoMultiEdge = arrayo.edgedMulti();
        bufferDummy = ByteBuffer.allocate(5);
    }

    // FIX 2130 Dupe with DefaultMethod use.
    private Method method() {
        java.lang.reflect.Method method = classer.getMethod(AutoEdgeByteBuffer.class, "duplicate");
        return new DefaultMethod(method);
    }

    public void testReturnEdge() {
        expect.oneCall(edgerMock, bufferMock, "edge", AutoEdgeByteBuffer.class, bufferDummy);
        Object result = subject.edge(bufferEdge, bufferDummy);
        assertSame(bufferMock, result);
    }

    public void testReturnEdgeForNonEdge() {
        Object result = subject.edge(streamEdge, stream.data());
        assertSame(stream.data(), result);
    }

    public void testReturnMultiArrayOfEdge() {
        Arrayo data = new Arrayo();
        Object[][] elements = data.multi();
        expect.manyCalls(edgerMock, elementMock, "edge", ArrayElement.class, elements[0][0]);
        Object result = subject.edge(arrayoMultiEdge, elements);
        ArrayElement[][] expected = {{elementMock, elementMock}, {elementMock, elementMock}};
        Object[][] actual = (Object[][]) result;
        assertEquals(2, actual.length);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    public void testReturnArrayOfEdge() {
        Arrayo data = new Arrayo();
        Object[] elements = data.single();
        expect.manyCalls(edgerMock, elementMock, "edge", ArrayElement.class, elements[0]);
        Object result = subject.edge(arrayoSingleEdge, elements);
        ArrayElement[] expected = {elementMock, elementMock};
        assertEquals(expected, (Object[]) result);
    }

    public void testReturnArrayOfReal() {
        Arrayo data = new Arrayo();
        Object[] elements = data.single();
        Object result = subject.edge(arrayoRealEdge, elements);
        assertEquals(elements, (Object[]) result);
    }
}
