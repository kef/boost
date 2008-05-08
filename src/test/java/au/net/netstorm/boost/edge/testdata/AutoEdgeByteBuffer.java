package au.net.netstorm.boost.edge.testdata;

import au.net.netstorm.boost.edge.core.Edge;

import java.nio.ByteBuffer;

public interface AutoEdgeByteBuffer extends Edge<ByteBuffer> {
    AutoEdgeByteBuffer duplicate();
}
