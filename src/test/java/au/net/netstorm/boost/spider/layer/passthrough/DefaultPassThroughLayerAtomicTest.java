package au.net.netstorm.boost.spider.layer.passthrough;

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

    public void testHandler() throws Throwable {
        map.put(key, value);
        PassThroughLayer layer = new DefaultPassThroughLayer();
        layer.setDelegate(map);
        Method isEmptyMethod = edgeClass.getMethod(Map.class, "get", PARAMETER_TYPES);
        Object actual = layer.invoke(map, isEmptyMethod, parameters);
        assertEquals(value, actual);
    }
}
