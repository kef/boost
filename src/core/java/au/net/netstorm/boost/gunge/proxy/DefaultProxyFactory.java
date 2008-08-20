package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.InterfaceMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterfaceMaster;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;

import java.lang.reflect.InvocationHandler;

public final class DefaultProxyFactory implements ProxyFactory {
    private final ProxySupplier supplier = new DefaultProxySupplier();
    private final InterfaceMaster interfaces = new DefaultInterfaceMaster();

    public Object proxy(InvocationHandler handler, Class[] types) {
        ClassLoader loader = loader();
        return supplier.getProxy(loader, types, handler);
    }

    public Object proxy(InvocationHandler handler, Interface[] types) {
        Class[] classes = interfaces.classes(types);
        return proxy(handler, classes);
    }

    private ClassLoader loader() {
        Class cls = getClass();
        return cls.getClassLoader();
    }
}
