package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.scalpel.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class DefaultStreamFixture implements StreamFixture {
    private byte[] data = {0x01, 0x02, 0x03};
    private InputStream in = new ByteArrayInputStream(data);
    private EdgeClass classer = new DefaultEdgeClass();
    private String method = "read";
    private Class<?>[] types = {byte[].class};
    private Method src = method(AutoEdgeInputStream.class);
    private Method trg = method(ByteArrayInputStream.class);

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

    // FIX 2130 Dupe.  See comments about getting in/out of DefaultMethod.
    private Method method(Class cls) {
        java.lang.reflect.Method method = classer.getMethod(cls, this.method, types);
        return new DefaultMethod(method);
    }
}
