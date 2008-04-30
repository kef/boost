package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMethodWarpAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private MethodWarp subject;

    EdgeChannelFixture channel;
    EdgeStreamFixture stream;

    EdgeClass classerMock;

    public void setUpFixtures() {
        subject = new DefaultMethodWarp();
    }

    public void testWarp() {
        expect.oneCall(classerMock, stream.trg(), "getMethod", InputStream.class, stream.method(), stream.types());
        Method result = subject.warp(InputStream.class, stream.src());
        assertEquals(stream.trg(), result);
    }

    public void testWarpWithEdgedArgs() {
        expect.oneCall(classerMock, channel.trg(), "getMethod", WritableByteChannel.class, channel.method(), channel.trgTypes());
        Method result = subject.warp(WritableByteChannel.class, channel.src());
        assertEquals(channel.trg(), result);
    }
}
