package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.io.InputStream;
import au.net.netstorm.boost.nursery.autoedge.Edge;

//FIX 2328 swap over to just use edge classes from demo tree
public interface AutoEdgeInputStream extends Edge<InputStream> {
    int read(byte[] out);
}
