package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;


public final class DefaultEdgeChannelFixture implements EdgeChannelFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private String method = "write";
    private Class<?>[] srcTypes = { AutoEdgeByteBuffer.class };
    private Class<?>[] trgTypes = { ByteBuffer.class };
    private Method src = classer.getMethod(AutoEdgeWritableByteChannel.class, method, srcTypes);
    private Method trg = classer.getMethod(WritableByteChannel.class, method, trgTypes);

    private int length = 5;
    private ByteBuffer buffer = ByteBuffer.allocate(length);
    private WritableByteChannel channel = new MockWritableByteChannel(buffer, length);

    public String method() { return method; }
    public Class<?>[] srcTypes() { return srcTypes; }
    public Class<?>[] trgTypes() { return trgTypes; }
    public Method src() { return src; }
    public Method trg() { return trg; }

    public int length() { return length; }
    public ByteBuffer buffer() { return buffer; }
    public WritableByteChannel channel() { return channel; }
}
