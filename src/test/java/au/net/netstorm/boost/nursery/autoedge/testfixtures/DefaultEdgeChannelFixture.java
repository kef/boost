package au.net.netstorm.boost.nursery.autoedge.testfixtures;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.nursery.autoedge.MockWritableByteChannel;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeWritableByteChannel;


public final class DefaultEdgeChannelFixture implements EdgeChannelFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private EdgeBufferFixture bufferFixture = new DefaultEdgeBufferFixture();
    private String method = "write";
    private Class<?>[] srcTypes = { AutoEdgeByteBuffer.class };
    private Class<?>[] trgTypes = { ByteBuffer.class };
    private Method src = classer.getMethod(AutoEdgeWritableByteChannel.class, method, srcTypes);
    private Method trg = classer.getMethod(WritableByteChannel.class, method, trgTypes);
    private WritableByteChannel channel = new MockWritableByteChannel(bufferFixture.buffer(), bufferFixture.length());

    public String method() { return method; }

    public Class<?>[] srcTypes() { return srcTypes; }

    public Class<?>[] trgTypes() { return trgTypes; }

    public Method src() { return src; }

    public Method trg() { return trg; }

    public int length() { return bufferFixture.length(); }

    public ByteBuffer buffer() { return bufferFixture.buffer(); }

    public WritableByteChannel channel() { return channel; }
}
