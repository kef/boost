package au.net.netstorm.boost.edge.testdata;

import au.net.netstorm.boost.edge.core.Edge;

import java.io.InputStream;

public interface AutoEdgeInputStream extends Edge<InputStream> {
    int read(byte[] out);
}
