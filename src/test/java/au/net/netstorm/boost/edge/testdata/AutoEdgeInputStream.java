package au.net.netstorm.boost.edge.testdata;

import au.net.netstorm.boost.edge.core.Edge;

public interface AutoEdgeInputStream extends Edge {
    int read(byte[] out);
}
