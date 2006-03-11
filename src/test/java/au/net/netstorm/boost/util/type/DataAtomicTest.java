package au.net.netstorm.boost.util.type;

import java.io.Serializable;

import au.net.netstorm.boost.reflect.ClassTestUtil;
import au.net.netstorm.boost.reflect.DefaultClassTestUtil;
import junit.framework.TestCase;

public class DataAtomicTest extends TestCase {
    private final ClassTestUtil clsProperties = new DefaultClassTestUtil();

    public void testInterfaceProperties() {
        isData(Serializable.class);
        isData(Immutable.class);
    }

    private void isData(Class type) {
        Interface iface = new Interface(type);
        boolean isImplemention = clsProperties.isImplementationOf(iface, Data.class);
        assertTrue(isImplemention);
    }

}
