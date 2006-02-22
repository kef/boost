package au.net.netstorm.boost.util.type;

import java.io.Serializable;

import au.net.netstorm.boost.util.reflect.DefaultClassPropertiesTestUtil;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import junit.framework.TestCase;

public class DataAtomicTest extends TestCase {
    private final ClassPropertiesTestUtil clsProperties = new DefaultClassPropertiesTestUtil();

    // FIXME: SC506 Refactor this.
    public void testInterfaceProperties() {
        assertTrue(isImplementationOf(Serializable.class));
        assertTrue(isImplementationOf(Immutable.class));
    }

    private boolean isImplementationOf(Class type) {
        return clsProperties.isImplementationOf(new Interface(type), Data.class);
    }
}
