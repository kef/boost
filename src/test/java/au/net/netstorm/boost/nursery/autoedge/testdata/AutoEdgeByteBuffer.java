package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.nio.ByteBuffer;
import au.net.netstorm.boost.nursery.autoedge.Edge;

// FIX 2328 swap over to just use edge classes from demo tree
public interface AutoEdgeByteBuffer extends Edge<ByteBuffer> {
    AutoEdgeByteBuffer duplicate();
}
