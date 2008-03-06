package au.net.netstorm.boost.reflect;

import java.lang.reflect.Proxy;
import java.rmi.Remote;
import java.security.PrivateKey;
import java.util.Collection;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultClassMasterAtomicTest extends BoooostCase {
    private final ClassMaster master = new DefaultClassMaster();

    public void testGetShortNameByClass() {
        checkGetShortNameByClass("Object", Object.class);
        checkGetShortNameByClass("Proxy", Proxy.class);
        checkGetShortNameByClass("String", String.class);
    }

    public void testGetShortNameByInterface() {
        testGetShortNameByInterface("Remote", Remote.class);
        testGetShortNameByInterface("CharSequence", CharSequence.class);
    }

    public void testGetPackageNameByClass() {
        checkGetPackageNameByClass("java.lang", String.class);
        checkGetPackageNameByClass("java.lang.reflect", Proxy.class);
    }

    public void testGetPackageNameByInterface() {
        checkGetPackageNameByInterface("java.util", Collection.class);
        checkGetPackageNameByInterface("java.security", PrivateKey.class);
    }

    private void checkGetShortNameByClass(String expected, Class cls) {
        String shortName = master.getShortName(cls);
        assertEquals(expected, shortName);
    }

    private void testGetShortNameByInterface(String expected, Class cls) {
        Interface iface = new DefaultInterface(cls);
        String shortName = master.getShortName(iface);
        assertEquals(expected, shortName);
    }

    private void checkGetPackageNameByClass(String expected, Class cls) {
        String packageName = master.getPackageName(cls);
        assertEquals(expected, packageName);
    }

    private void checkGetPackageNameByInterface(String expected, Class cls) {
        Interface iface = new DefaultInterface(cls);
        String packageName = master.getPackageName(iface);
        assertEquals(expected, packageName);
    }
}
