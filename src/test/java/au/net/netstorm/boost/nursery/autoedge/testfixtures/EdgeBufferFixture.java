package au.net.netstorm.boost.nursery.autoedge.testfixtures;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

// FIX 2328 tidy up fixtures, particularly the names for the data pars
public interface EdgeBufferFixture {
    String method();

    Method src();

    Method trg();

    int length();

    ByteBuffer buffer();

    Class<?> realImpl();

    Type[] edgeInterfaceTypes();
}
