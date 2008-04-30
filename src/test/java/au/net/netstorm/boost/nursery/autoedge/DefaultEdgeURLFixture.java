package au.net.netstorm.boost.nursery.autoedge;

import java.net.MalformedURLException;
import java.net.URL;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeURLFixture implements EdgeURLFixture {
    private String value = "http://url";
    private URL url = url(value);

    public URL url() { return url; }
    public String value() { return value; }

    private URL url(String value) {
        try {
            return new URL(value);
        } catch (MalformedURLException e) {
            throw new EdgeException(e);
        }
    }
}
