package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.io.InputStream;

import au.net.netstorm.boost.nursery.autoedge.Edge;

public interface AutoEdgeInputStream extends Edge<InputStream> {
    int read(byte[] out);
}
