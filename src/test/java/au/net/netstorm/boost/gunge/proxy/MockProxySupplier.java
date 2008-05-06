package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.retire.reflect.AssertTestChecker;
import au.net.netstorm.boost.retire.reflect.DefaultAssertTestChecker;
import junit.framework.Assert;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;

final class MockProxySupplier extends Assert implements ProxySupplier {
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
        assertEquals(handler, this.handler);
    }

    private Class[] toClasses(Interface[] types) {
        List result = new ArrayList();
        for (Interface type : types) {
            Class cls = type.getType();
            result.add(cls);
        }
        return (Class[]) result.toArray(new Class[]{});
    }
}
