package au.net.netstorm.boost.spider.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerInvocationHandlerAtomicTest extends InteractionTestCase {
    InvocationHandler subject;
    ProviderEngine provider;
    Implementation impl;
    Object proxyObject;
    ResolvedInstance newedInstance;
    Object[] methodParams = new Object[]{};
    Object newedObject;

    public void setupSubjects() {
        subject = new NewerInvocationHandler(provider, impl);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(provider, newedInstance, "provide", impl, methodParams);
        expect.oneCall(newedInstance, newedObject, "getRef");
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(newedObject, actualObject);
    }
}