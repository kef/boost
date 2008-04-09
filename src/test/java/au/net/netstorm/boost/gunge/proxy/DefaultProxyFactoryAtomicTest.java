package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.Map;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.compose.MockLayer;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultProxyFactoryAtomicTest extends BoooostCase {
    private static final Interface TYPE_1 = new DefaultInterface(CharSequence.class);
    private static final Interface TYPE_2 = new DefaultInterface(Map.class);
    private static final Interface[] TYPES = {TYPE_1, TYPE_2};
    private final MockProxySupplier proxySupplier = new MockProxySupplier();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ProxyFactory factory = new DefaultProxyFactory();
    private final Layer layer = new MockLayer();

    {
        fielder.setInstance(factory, "delegate", proxySupplier);
    }

    public void testSingleType() {
        checkSingleType(TYPE_1);
        checkSingleType(TYPE_2);
    }

    public void testMultipleTypes() {
        checkMultipleTypes(TYPES);
    }

    private void checkSingleType(Interface type) {
        Object expected = prepare();
        Object result = factory.newProxy(type, layer);
        assertSame(expected, result);
        checkCall(type);
    }

    private void checkMultipleTypes(Interface[] types) {
        Object expected = prepare();
        Object result = factory.newProxy(types, layer);
        assertSame(expected, result);
        checkCall(types);
    }

    private Object prepare() {
        Object expected = new Object();
        proxySupplier.init(expected);
        return expected;
    }

    private void checkCall(Interface type) {
        Interface[] types = {type};
        checkCall(types);
    }

    private void checkCall(Interface[] types) {
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        InvocationHandler handler = new LayerInvocationHandler(layer);
        proxySupplier.verify(classLoader, types, handler);
    }
}