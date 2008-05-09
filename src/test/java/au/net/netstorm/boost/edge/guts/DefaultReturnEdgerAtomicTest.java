package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultReturnEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Method bufferEdge;
    private Method streamEdge;
    private ReturnEdger subject;
    private ByteBuffer bufferDummy;
    private StreamFixture stream;
    AutoEdger edgerMock;
    AutoEdgeByteBuffer bufferMock;
    EdgeClass classer;

    public void setUpFixtures() {
        subject = new DefaultReturnEdger();
        stream = new StreamFixture();
        bufferEdge = classer.getMethod(AutoEdgeByteBuffer.class, "duplicate");
        streamEdge = stream.edgeMethod();
        bufferDummy = ByteBuffer.allocate(5);
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
}