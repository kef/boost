package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.nio.ByteBuffer;

import au.net.netstorm.boost.nursery.autoedge.Edge;

public interface AutoEdgeByteBuffer extends Edge<ByteBuffer> {
    AutoEdgeByteBuffer duplicate();
}
