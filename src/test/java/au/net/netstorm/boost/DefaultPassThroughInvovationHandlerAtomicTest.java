package au.net.netstorm.boost;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import junit.framework.TestCase;

// FIX 1665 Move into appropriate package.

// FIX 1665 Fix FIX #.
public final class DefaultPassThroughInvovationHandlerAtomicTest extends TestCase {
    private static final Class[] PARAMETER_TYPES = {Object.class};
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private Map map = new HashMap();
    private Object key = new Object();
    private Object value = new Object();
    private Object[] parameters = {key};

    public void testHandler() throws Throwable {
        // FIX 1665 Complete this.
        map.put(key, value);
        PassThroughInvocationHandler handler = new DefaultPassThroughInvocationHandler();
        handler.setDelegate(map);
        Method isEmptyMethod = edgeClass.getMethod(Map.class, "get", PARAMETER_TYPES);
        Object actual = handler.invoke(map, isEmptyMethod, parameters);
        assertEquals(value, actual);
    }
}
