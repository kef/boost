package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.nursery.compose.MockClosure;
import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

public final class DefaultProxyFactoryAtomicTest extends BoooostCase {
    private static final Interface TYPE_1 = new DefaultInterface(CharSequence.class);
    private static final Interface TYPE_2 = new DefaultInterface(Map.class);
    private static final Interface[] TYPES = {TYPE_1, TYPE_2};
    private final MockProxySupplier proxySupplier = new MockProxySupplier();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ProxyFactory factory = new DefaultProxyFactory();
    private final Closure closure = new MockClosure();

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
        Object result = factory.newProxy(type, closure);
        assertSame(expected, result);
        checkCall(type);
    }

    private void checkMultipleTypes(Interface[] types) {
        Object expected = prepare();
        Object result = factory.newProxy(types, closure);
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
        InvocationHandler handler = new ClosureInvocationHandler(closure);
        proxySupplier.verify(classLoader, types, handler);
    }
}