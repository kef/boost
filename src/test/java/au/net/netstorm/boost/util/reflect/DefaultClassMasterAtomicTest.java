package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Proxy;
import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public class DefaultClassMasterAtomicTest extends TestCase {
    private final ClassMaster master = new DefaultClassMaster();

    public void testClass() {
        checkEquals("Object", Object.class);
        checkEquals("Proxy", Proxy.class);
        checkEquals("String", String.class);
    }

    public void testInterface() {
        Class type = Remote.class;
        Interface iface = new Interface(type);
        String actual = master.getShortName(iface);
        assertEquals("Remote", actual);
//        checkEquals("Remote", Remote.class);
//        checkEquals("Remote", Remote.class);
    }

    private void checkEquals(String expected, Class cls) {
        assertEquals(expected, master.getShortName(cls));
    }
}
