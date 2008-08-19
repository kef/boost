package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.check.AssertTestChecker;
import au.net.netstorm.boost.sniper.check.DefaultAssertTestChecker;
import au.net.netstorm.boost.spider.onion.core.Layered;
import junit.framework.Assert;

final class MockProxySupplier extends Assert implements ProxySupplier {
    private static final Interface LAYERED = new DefaultInterface(Layered.class);
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();
    private final ArrayMaster arrays = new DefaultArrayMaster();
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
        Interface[] all = layered(ifaces);
        Class[] types = toClasses(all);
        assertSame(loader, this.loader);
        asserter.checkEquals(types, this.types);
        assertEquals(handler, this.handler);
    }

    private Interface[] layered(Interface[] ifaces) {
        return arrays.plus(ifaces, LAYERED);
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
