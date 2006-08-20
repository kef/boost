package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.test.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultAssertTestChecker;
import au.net.netstorm.boost.util.type.DefaultInterface;
import junit.framework.Assert;

import java.lang.reflect.InvocationHandler;

final class MockEdgeProxy extends Assert implements EdgeProxy {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();
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

    public void verify(ClassLoader loader, DefaultInterface[] ifaces, InvocationHandler handler) {
        Class[] types = toClasses(ifaces);
        assertSame(loader, this.loader);
        asserter.checkEquals(types, this.types);
        assertSame(handler, this.handler);
    }

    private Class[] toClasses(DefaultInterface[] types) {
        int length = types.length;
        Class[] result = new Class[length];
        for (int i = 0; i < length; i++) {
            result[i] = types[i].getType();
        }
        return result;
    }
}
