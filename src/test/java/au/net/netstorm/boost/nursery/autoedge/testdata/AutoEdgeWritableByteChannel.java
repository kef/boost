package au.net.netstorm.boost.nursery.autoedge.testdata;

import java.nio.channels.WritableByteChannel;
import au.net.netstorm.boost.nursery.autoedge.Edge;

//FIX 2328 swap over to just use edge classes from demo tree
public interface AutoEdgeWritableByteChannel extends Edge<WritableByteChannel> {
    int write(AutoEdgeByteBuffer src);
}
