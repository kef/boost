package au.net.netstorm.boost.nursery.autoedge.testfixtures;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultEdgeStreamFixture implements EdgeStreamFixture {
    private byte[] data = {0x01, 0x02, 0x03};
    private InputStream in = new ByteArrayInputStream(data);
    private EdgeClass classer = new DefaultEdgeClass();
    private String method = "read";
    private Class<?>[] types = {byte[].class};
    private Method src = classer.getMethod(ByteArrayInputStream.class, method, types);
    private Method trg = classer.getMethod(ByteArrayInputStream.class, method, types);

    public String method() {
        return method;
    }

    public Class<?>[] types() {
        return types;
    }

    public Method edge() {
        return src;
    }

    public Method real() {
        return trg;
    }

    public InputStream stream() {
        return in;
    }

    public int length() {
        return data.length;
    }

    public byte[] data() {
        return data;
    }
}
