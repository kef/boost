package au.net.netstorm.boost.spider.onion.layer.passthrough;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.cases.BoooostCase;

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
        Method getMethod = edgeClass.getMethod(Map.class, "get", PARAMETER_TYPES);
        Object actual = layer.invoke(map, getMethod, parameters);
        assertEquals(value, actual);
    }
}
