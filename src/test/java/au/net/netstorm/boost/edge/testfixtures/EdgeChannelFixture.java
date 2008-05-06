package au.net.netstorm.boost.edge.testfixtures;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

//FIX 2328 tidy up fixtures, particularly the names for the data pars
public interface EdgeChannelFixture {
    String method();

    Class<?>[] srcTypes();

    Class<?>[] trgTypes();

    Method src();

    Method trg();

    WritableByteChannel channel();

    int length();

    ByteBuffer buffer();
}
