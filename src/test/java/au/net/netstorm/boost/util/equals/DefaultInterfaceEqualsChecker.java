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

    public void checkEquals(Object expected, Object actual) {
        Assert.assertTrue("Not equal!", compare(expected, actual));
    }

    public void checkNotEquals(Object expected, Object actual) {
        Assert.assertTrue("Equal!", !compare(expected, actual));
    }

    private boolean compare(Object expected, Object actual) {
        Class expectedClass = expected.getClass();
        Method[] methods = methoder.getAllNotInheritedPublicInstance(expectedClass);
        for (int i = 0; i < methods.length; i++) {
            Method expMethod = methods[i];
            if (compareMethodsIfSupported(expMethod, actual, expected)) return false;
        }
        return true;
    }

    private boolean compareMethodsIfSupported(Method method, Object actual, Object expected) {
        Method actMethod = getMatchingMethod(actual, method);
        return (compareMethodResults(method, expected, actMethod, actual));
    }

    private boolean compareMethodResults(Method expMethod, Object expected, Method actMethod, Object actual) {
        Object expectedResult = edgeMethod.invoke(expMethod, expected, null);
        Object actualResult = edgeMethod.invoke(actMethod, actual, null);
        if (isProxy(expectedResult)) {
            if (!compare(expectedResult, actualResult)) return true;
        } else {
            if (!expectedResult.equals(actualResult)) return true;
        }
        return false;
    }

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
