package au.net.netstorm.boost.util.equals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.random.DummyInterfaceInvocationHandler;
import au.net.netstorm.boost.test.reflect.util.ClassMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultClassMethodTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultMethodSpec;
import au.net.netstorm.boost.util.introspect.MethodSpec;

// FIX 2076 Move near EqualsMaster, even though this is in test code.
public final class DummyEqualsMaster implements EqualsMaster {
    ClassMethodTestUtil methoder = new DefaultClassMethodTestUtil();
    ReflectMaster reflector = new DefaultReflectMaster();
    EdgeMethod edgeMethod = new DefaultEdgeMethod();

    public boolean equals(Object o1, Object o2) {
        if (isDummy(o1, o2)) return compareByMethods(o1, o2);
        return compareByEquals(o1, o2);
    }

    // FIX BREADCRUMB 2076 UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU Implement ArrayEqualsMaster and stitch in.
    // FIX BREADCRUMB 2076 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT Export.

    private boolean compareByEquals(Object o1, Object o2) {
        return o1.equals(o2);
    }

    private boolean isDummy(Object o1, Object o2) {
        if (isDummyProxy(o1)) return true;
        return isDummyProxy(o2);
    }

    // FIX 2076 CLASS-------------------- Move this out.

    private boolean compareByMethods(Object o1, Object o2) {
        Class cls = o1.getClass();
        Method[] methods = methoder.getAllNotInheritedPublicInstance(cls);
        for (int i = 0; i < methods.length; i++) {
            if (compareMethods(methods[i], o1, o2)) return false;
        }
        return true;
    }

    private boolean compareMethods(Method method1, Object o1, Object o2) {
        Method method2 = getMatchingMethod(o2, method1);
        return compareMethods(method1, o1, method2, o2);
    }

    private boolean compareMethods(Method method1, Object o1, Method method2, Object o2) {
        Object result1 = edgeMethod.invoke(method1, o1, null);
        Object result2 = edgeMethod.invoke(method2, o2, null);
        return equals(result1, result2);
    }

    // FIX 2076 CLASS-------------------- Move this out.

    private Method getMatchingMethod(Object actual, Method expMethod) {
        Class[] params = expMethod.getParameterTypes();
        String name = expMethod.getName();
        MethodSpec spec = new DefaultMethodSpec(name, params);
        Class cls = actual.getClass();
        return reflector.getMethod(cls, spec);
    }

    // FIX 2076 Move this out.
    private boolean isDummyProxy(Object expectedResult) {
        if (!Proxy.class.isAssignableFrom(expectedResult.getClass())) return false;
        InvocationHandler handler = Proxy.getInvocationHandler(expectedResult);
        return DummyInterfaceInvocationHandler.class.isAssignableFrom(handler.getClass());
    }
}
