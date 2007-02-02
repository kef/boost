package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;
import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

final class MockEdgeProxySupplier extends Assert implements EdgeProxySupplier {
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

    public void verify(ClassLoader loader, Interface[] ifaces, InvocationHandler handler) {
        Class[] types = toClasses(ifaces);
        assertSame(loader, this.loader);
        asserter.checkEquals(types, this.types);
        assertSame(handler, this.handler);
    }

    private Class[] toClasses(Interface[] types) {
        List result = new ArrayList();
        for (int i = 0; i < types.length; i++) {
            Class cls = types[i].getType();
            result.add(cls);
        }
        return (Class[]) result.toArray(new Class[]{});
    }
}
