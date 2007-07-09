package au.net.netstorm.boost.util.equals;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.reflect.util.ClassMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultClassMethodTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultMethodSpec;
import au.net.netstorm.boost.util.introspect.MethodSpec;
import junit.framework.Assert;

// FIX 2076 Delete me or not...
public final class DefaultInterfaceEqualsChecker implements InterfaceEqualsChecker {
    ReflectMaster reflector = new DefaultReflectMaster();
    ClassMethodTestUtil methoder = new DefaultClassMethodTestUtil();
    EdgeMethod edgeMethod = new DefaultEdgeMethod();

    // FIX 2076 Needs to support real/proxies passed in in any order.
    public void checkEquals(Object expected, Object actual) {
        Assert.assertTrue("Not equal!", compare(expected, actual));
    }

    public void checkNotEquals(Object expected, Object actual) {
        Assert.assertTrue("Equal!", !compare(expected, actual));
    }

    private boolean compare(Object proxy, Object real) {
        Class cls = proxy.getClass();
        Method[] methods = methoder.getAllNotInheritedPublicInstance(cls);
        for (int i = 0; i < methods.length; i++) {
            if (compareMethods(methods[i], proxy, real)) return false;
        }
        return true;
    }

    private boolean compareMethods(Method proxyMethod, Object proxy, Object real) {
        Method realMethod = getMatchingMethod(real, proxyMethod);
        return compareMethods(proxyMethod, proxy, realMethod, real);
    }

    private boolean compareMethods(Method proxyMethod, Object proxy, Method realMethod, Object real) {
        Object proxyResult = edgeMethod.invoke(proxyMethod, proxy, null);
        Object realResult = edgeMethod.invoke(realMethod, real, null);
        if (isProxy(proxyResult)) {
            if (!compare(proxyResult, realResult)) return true;
        } else {
            if (!proxyResult.equals(realResult)) return true;
        }
        return false;
    }

    // FIX 2076 Move this out.
    private Method getMatchingMethod(Object actual, Method expMethod) {
        Class[] params = expMethod.getParameterTypes();
        String name = expMethod.getName();
        MethodSpec spec = new DefaultMethodSpec(name, params);
        Class cls = actual.getClass();
        return reflector.getMethod(cls, spec);
    }

    private boolean isProxy(Object expectedResult) {
        return Proxy.class.isAssignableFrom(expectedResult.getClass());
    }
}
