package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public interface EdgeChannelFixture {
    String method();
    Class<?>[] srcTypes();
    Class<?>[] trgTypes();
    Method src();
    Method trg();

    int length();
    ByteBuffer buffer();
    WritableByteChannel channel();
}
