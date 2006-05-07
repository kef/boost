package au.net.netstorm.boost.reflect;

import junit.framework.TestCase;

public final class DefaultReflectEdgeTest extends TestCase {
    private final ReflectEdge reflector = DefaultReflectEdge.INSTANCE;
    private static final Class REFLECT_EDGE_CLASS = ReflectEdge.class;
    private static final String NON_EXISTENT_CLASS_NAME = "NonExistentClass";

    public void testForName() {
        String name = REFLECT_EDGE_CLASS.getName();
        Class cls = reflector.forName(name);
        assertEquals(REFLECT_EDGE_CLASS, cls);
    }

    public void testForNameException() {
        try {
            reflector.forName(NON_EXISTENT_CLASS_NAME);
        } catch (EdgeClassNotFoundException expected) { }
    }
}