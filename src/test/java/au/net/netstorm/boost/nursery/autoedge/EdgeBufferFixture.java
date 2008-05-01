package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

public interface EdgeBufferFixture {
    String method();
    Method src();
    Method trg();
    int length();
    ByteBuffer buffer();
    Class<?> realImpl();
    Type[] edgeInterfaceTypes();
}
