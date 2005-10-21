package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Proxy;
import java.rmi.Remote;

import junit.framework.TestCase;

public class DefaultClassMasterAtomicTest extends TestCase {
    private final ClassMaster master = new DefaultClassMaster();

    public void testClassName() {
        checkEquals("Object", Object.class);
        checkEquals("Proxy", Proxy.class);
        checkEquals("Remote", Remote.class);
    }

    private void checkEquals(String expected, Class cls) {
        assertEquals(expected, master.getShortName(cls));
    }
}
