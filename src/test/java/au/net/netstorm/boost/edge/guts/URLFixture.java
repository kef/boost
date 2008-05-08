package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;

public final class URLFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private String value = "http://url";
    private URL url = url(value);
    private Constructor<?> constructor = classer.getConstructor(URL.class, String.class);

    public Constructor<?> constructor() {
        return constructor;
    }

    public URL real() {
        return url;
    }

    public String arg() {
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
