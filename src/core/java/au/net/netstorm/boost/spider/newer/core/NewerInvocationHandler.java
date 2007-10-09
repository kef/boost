package au.net.netstorm.boost.spider.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
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
        return nullSafeInvoke(params);
    }

    private Object nullSafeInvoke(Object[] params) {
        Object[] cleanParams = clean(params);
        return invoke(cleanParams);
    }

    private Object invoke(Object[] params) {
        ResolvedInstance instance = provider.provide(impl, params);
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
