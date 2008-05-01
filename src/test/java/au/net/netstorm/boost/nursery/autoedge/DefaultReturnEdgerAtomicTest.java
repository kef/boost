package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeBufferFixture;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeStreamFixture;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultReturnEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private ReturnEdger subject;
    EdgeStreamFixture streamFixture;
    EdgeBufferFixture bufferFixture;

    AutoEdger edgerMock;
    AutoEdgeByteBuffer bufferMock;

    public void setUpFixtures() {
        subject = new DefaultReturnEdger();
    }

    public void testReturnEdge() {
        expect.oneCall(edgerMock, bufferMock, "edge", AutoEdgeByteBuffer.class, bufferFixture.buffer());
        Object result = subject.edge(bufferFixture.src(), bufferFixture.buffer());
        assertSame(bufferMock, result);
    }

    public void testReturnEdgeForNonEdge() {
        Object result = subject.edge(streamFixture.src(), streamFixture.data());
        assertSame(streamFixture.data(), result);
    }
}
