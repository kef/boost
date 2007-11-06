package au.net.netstorm.boost.spider.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerInvocationHandler implements InvocationHandler {
    private ProviderEngine provider;
    private Implementation impl;

    public NewerInvocationHandler(ProviderEngine provider, Implementation impl) {
        this.provider = provider;
        this.impl = impl;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        check(method);
        Class returnType = method.getReturnType();
        Interface iface = new DefaultInterface(returnType);
        return nullSafeInvoke(iface, params);
    }

    private Object nullSafeInvoke(Interface iface, Object[] params) {
        Object[] cleanParams = clean(params);
        return invoke(iface, cleanParams);
    }

    private Object invoke(Interface iface, Object[] params) {
        ResolvedInstance instance = provider.provide(iface, impl, params);
        return instance.getRef();
    }

    private Object[] clean(Object[] params) {
        if (params != null) return params;
        return new Object[0];
    }

    private void check(Method method) {
        String name = method.getName();
        if (name.equals("nu")) return;
        throw new IllegalStateException("We only support nu(...) methods");
    }
}
