package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.support.EdgeException;

public final class DefaultURLFixture implements URLFixture {
    private EdgeClass classer = new DefaultEdgeClass();
    private String value = "http://localhost";
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
