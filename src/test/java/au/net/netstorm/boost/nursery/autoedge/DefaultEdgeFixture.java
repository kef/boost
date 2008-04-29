package au.net.netstorm.boost.nursery.autoedge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultEdgeFixture implements EdgeFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private byte[] data = { 0x01, 0x02, 0x03 };
    private String value = "http://url";
    private URL url = url(value);
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

    public URL url() {
        return url;
    }

    public String value() {
        return value;
    }

    private URL url(String value) {
        try {
            return new URL(value);
        } catch (MalformedURLException e) {
            throw new EdgeException(e);
        }
    }
}
