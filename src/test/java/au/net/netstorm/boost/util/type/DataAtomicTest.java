package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultClassTestUtil;
import junit.framework.TestCase;

import java.io.Serializable;

public class DataAtomicTest extends TestCase {
    private final ClassTestUtil clsProperties = new DefaultClassTestUtil();

    public void testInterfaceProperties() {
        isData(Serializable.class);
        isData(Immutable.class);
    }

    private void isData(Class type) {
        Interface iface = new DefaultInterface(type);
        boolean isImplemention = clsProperties.isImplementationOf(iface, Data.class);
        assertTrue(isImplemention);
    }
}
