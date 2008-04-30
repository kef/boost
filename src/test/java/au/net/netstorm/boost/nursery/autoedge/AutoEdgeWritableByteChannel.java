package au.net.netstorm.boost.nursery.autoedge;

import java.nio.channels.WritableByteChannel;

public interface AutoEdgeWritableByteChannel extends Edge<WritableByteChannel> {
    int write(AutoEdgeByteBuffer src);
}
