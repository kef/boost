package au.net.netstorm.boost.nursery.autoedge;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeCompoundAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge<WritableByteChannel> subject;
    private AutoEdge<ByteBuffer> cosubject;

    EdgeChannelFixture fixture;

    MethodWarp warperMock;
    EdgeMethod invokerMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge<WritableByteChannel>(fixture.channel());
        cosubject = new DefaultAutoEdge<ByteBuffer>(fixture.buffer());
    }

    public void testInvokeWithEdgedArgument() {
        WritableByteChannel channel = fixture.channel();
        expect.oneCall(warperMock, fixture.trg(), "warp", MockWritableByteChannel.class, fixture.src());
        expect.oneCall(invokerMock, fixture.length(), "invoke", fixture.trg(), channel, new Object[] { fixture.buffer() });

        Object[] args = { cosubject };
        Object length = subject.invoke(channel, fixture.src(), args);
        assertEquals(fixture.length(), length);
    }
}
