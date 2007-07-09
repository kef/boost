package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// SUGGEST: Move into production.
public final class DefaultClassMethodTestUtil implements ClassMethodTestUtil {
    private final Set exclusions = new HashSet();
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    {
        init();
    }

    public Method[] getAll(Class cls) {
        return cls.getDeclaredMethods();
    }

    // FIX BREADCRUMB 2076 ZZZZZZZZZZZZZZZZZZZZZZZZZZZZ Use this in DIEC.
    public Method[] getAllPublicInstance(Class cls) {
        Set result = getAllAsSet(cls);
        keepPublicInstance(result);
        return methods(result);
    }

    public Method[] getAllNonInherited(Class cls) {
        Set result = getAllAsSet(cls);
        keepNonInherited(result);
        return methods(result);
    }

    public Method[] getAllNotInheritedPublicInstance(Class cls) {
        Set result = getAllAsSet(cls);
        keepNonInherited(result);
        keepPublicInstance(result);
        return methods(result);
    }

    private Set getAllAsSet(Class cls) {
        Method[] all = cls.getDeclaredMethods();
        List list = Arrays.asList(all);
        return new HashSet(list);
    }

    private void keepPublicInstance(Set set) {
        Method[] methods = methods(set);
        for (int i = 0; i < methods.length; i++) {
            keepPublicInstance(set, methods[i]);
        }
    }

    private void keepNonInherited(Set set) {
        Method[] methods = methods(set);
        for (int i = 0; i < methods.length; i++) {
            keepNonInherited(set, methods[i]);
        }
    }

    private void keepPublicInstance(Set set, Method method) {
        if (!modifierUtil.isPublicInstance(method)) {
            set.remove(method);
        }
    }

    private void keepNonInherited(Set set, Method method) {
        String name = method.getName();
        if (exclusions.contains(name)) {
            set.remove(method);
        }
    }

    private Method[] methods(Set set) {
        return (Method[]) set.toArray(new Method[]{});
    }

    private void init() {
        exlusionsForObject();
        exclusionsForProxy();
    }

    private void exclusionsForProxy() {
        exclusions.add("newProxyInstance");
        exclusions.add("getProxyClass");
        exclusions.add("getInvocationHandler");
        exclusions.add("isProxyClass");
    }

    private void exlusionsForObject() {
        exclusions.add("toString");
        exclusions.add("hashCode");
        exclusions.add("equals");
        exclusions.add("getClass");
        exclusions.add("wait");
        exclusions.add("notify");
        exclusions.add("notifyAll");
    }
}
