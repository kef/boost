package au.net.netstorm.boost.scalpel.testdata;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface AutoEdgeInputStream extends Edge {
    int read(byte[] out);
}
