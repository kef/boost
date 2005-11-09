package au.net.netstorm.boost.util.reflect;

import junit.framework.TestCase;

public final class DefaultReflectEdgeTest extends TestCase {
    private final ReflectEdge reflector = DefaultReflectEdge.INSTANCE;
    private static final Class REFLECT_EDGE_CLASS = ReflectEdge.class;

    public void testForName() {
        String name = REFLECT_EDGE_CLASS.getName();
        Class cls = reflector.forName(name);
        assertEquals(REFLECT_EDGE_CLASS, cls);
    }
}