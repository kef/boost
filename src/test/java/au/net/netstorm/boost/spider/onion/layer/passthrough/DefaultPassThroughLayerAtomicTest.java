package au.net.netstorm.boost.spider.onion.layer.passthrough;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.test.core.BoooostCase;

import java.util.HashMap;
import java.util.Map;

public final class DefaultPassThroughLayerAtomicTest extends BoooostCase {
    private static final Class[] PARAMETER_TYPES = {Object.class};
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private Map map = new HashMap();
    private Object key = new Object();
    private Object value = new Object();
    private Object[] parameters = {key};

    // FIX 1936 Testing this becomes a whole lot easier when ONION w/ outside/inside is complete.
    // FIX 1936 Do the "put" as well.
    // FIX 1936 Need to triangulate and test more modes.
    // FIX 1936 Drive up a ThrowableUtil.
    public void testHandler() throws Throwable {
        map.put(key, value);
        PassThroughLayer layer = new DefaultPassThroughLayer();
        layer.setDelegate(map);
        Method method = getMethod();
        Object actual = layer.invoke(method, parameters);
        assertEquals(value, actual);
    }

    private Method getMethod() {
        java.lang.reflect.Method method = edgeClass.getMethod(Map.class, "get", PARAMETER_TYPES);
        return new DefaultMethod(method);
    }
}
