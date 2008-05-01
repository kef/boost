package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.nursery.autoedge.Edge;

public interface AutoEdgeWritableByteChannel extends Edge<WritableByteChannel> {
    int write(AutoEdgeByteBuffer src);
}
