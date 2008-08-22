package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

import java.io.InputStream;

public interface StreamFixture {
    String methodName();

    Class<?>[] argTypes();

    Method edgeMethod();

    Method realMethod();

    InputStream real();

    int length();

    byte[] data();
}
