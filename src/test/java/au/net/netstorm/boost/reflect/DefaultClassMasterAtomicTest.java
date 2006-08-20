package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

import java.lang.reflect.Proxy;
import java.rmi.Remote;

public class DefaultClassMasterAtomicTest extends TestCase {
    private final ClassMaster master = new DefaultClassMaster();

    public void testClass() {
        checkClass("Object", Object.class);
        checkClass("Proxy", Proxy.class);
        checkClass("String", String.class);
    }

    public void testInterface() {
        checkInterface("Remote", Remote.class);
        checkInterface("CharSequence", CharSequence.class);
    }

    private void checkClass(String expected, Class cls) {
        String shortName = master.getShortName(cls);
        assertEquals(expected, shortName);
    }

    private void checkInterface(String expected, Class type) {
        Interface iface = new DefaultInterface(type);
        String shortName = master.getShortName(iface);
        assertEquals(expected, shortName);
    }
}
