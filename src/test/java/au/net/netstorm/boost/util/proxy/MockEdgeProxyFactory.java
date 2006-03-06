package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.primordial.AssertTestUtil;
import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

final class MockEdgeProxyFactory extends Assert implements EdgeProxyFactory {
    private final AssertTestUtil asserter = new AssertTestUtil();
    private ClassLoader loader;
    private Class[] types;
    private InvocationHandler handler;
    private Object result;

    public Object getProxy(ClassLoader loader, Class[] types, InvocationHandler handler) {
        this.loader = loader;
        this.types = types;
        this.handler = handler;
        return result;
    }

    public void init(Object result) {
        this.result = result;
        loader = null;
        types = null;
        handler = null;
    }

    public void verify(ClassLoader loader, Interface[] ifaces, InvocationHandler handler) {
        Class[] types = toClasses(ifaces);
        assertSame(loader, this.loader);
        // FIXME: SC521 Reinstate.
//        assertEquals(types, this.types);
//        assertSame(handler, this.handler);
    }

    private Class[] toClasses(Interface[] types) {
        int length = types.length;
        Class[] result = new Class[length];
        for (int i = 0; i < length; i++) {
            result[i] = types[i].getType();
        }
        return result;
    }
}
