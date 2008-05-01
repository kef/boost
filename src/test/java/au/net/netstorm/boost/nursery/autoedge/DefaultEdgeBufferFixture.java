package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;


public final class DefaultEdgeBufferFixture implements EdgeBufferFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private String method = "duplicate";
    private Method src = classer.getMethod(AutoEdgeByteBuffer.class, method);
    private Method trg = classer.getMethod(ByteBuffer.class, method);

    private int length = 5;
    private ByteBuffer buffer = ByteBuffer.allocate(length);
    private Class<?> impl = buffer.getClass();

    public String method() { return method; }
    public Method src() { return src; }
    public Method trg() { return trg; }

    public int length() { return length; }
    public ByteBuffer buffer() { return buffer; }
    public Class<?> realImpl() { return impl; }
    public Type[] edgeInterfaceTypes() { return AutoEdgeByteBuffer.class.getGenericInterfaces(); }
}
