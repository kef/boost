package au.net.netstorm.boost.edge.guts;

import java.io.InputStream;
import java.lang.reflect.Method;


public interface StreamFixture {
    String methodName();

    Class<?>[] argTypes();

    Method edgeMethod();

    Method realMethod();

    InputStream real();

    int length();

    byte[] data();
}
