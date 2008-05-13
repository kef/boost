package au.net.netstorm.boost.scalpel.engine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultStreamFixture implements StreamFixture {
    private byte[] data = {0x01, 0x02, 0x03};
    private InputStream in = new ByteArrayInputStream(data);
    private EdgeClass classer = new DefaultEdgeClass();
    private String method = "read";
    private Class<?>[] types = {byte[].class};
    private Method src = classer.getMethod(ByteArrayInputStream.class, method, types);
    private Method trg = classer.getMethod(ByteArrayInputStream.class, method, types);

    public String methodName() {
        return method;
    }

    public Class<?>[] argTypes() {
        return types;
    }

    public Method edgeMethod() {
        return src;
    }

    public Method realMethod() {
        return trg;
    }

    public InputStream real() {
        return in;
    }

    public int length() {
        return data.length;
    }

    public byte[] data() {
        return data;
    }
}
