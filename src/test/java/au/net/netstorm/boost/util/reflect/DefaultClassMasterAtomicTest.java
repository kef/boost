package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Proxy;
import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public class DefaultClassMasterAtomicTest extends TestCase {
    private final ClassMaster master = new DefaultClassMaster();

    public void testClass() {
        checkClass("Object", Object.class);
        checkClass("Proxy", Proxy.class);
        checkClass("String", String.class);
    }

    public void testInterface() {
        Class type = Remote.class;
        String expected = "Remote";
        checkInterface(type, expected);
//        checkEquals("Remote", Remote.class);
//        checkEquals("Remote", Remote.class);
    }

    // FIXME: SC042 Dupe.
    private void checkClass(String expected, Class cls) {
        String shortName = master.getShortName(cls);
        assertEquals(expected, shortName);
    }

    private void checkInterface(Class type, String expected) {
        Interface iface = new Interface(type);
        String shortName = master.getShortName(iface);
        assertEquals(expected, shortName);
    }
}
