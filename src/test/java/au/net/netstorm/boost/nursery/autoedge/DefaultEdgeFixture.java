package au.net.netstorm.boost.nursery.autoedge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultEdgeFixture implements EdgeFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private byte[] data = { 0x01, 0x02, 0x03 };
    Method read = classer.getDeclaredMethod(InputStream.class, "read",  byte[].class);
    InputStream in = new ByteArrayInputStream(data);
    MethodWarp warper;

    public byte[] data() {
        return data;
    }

    public int length() {
        return data.length;
    }

    public InputStream stream() {
        return in;
    }

    public Method read() {
        return read;
    }
}
