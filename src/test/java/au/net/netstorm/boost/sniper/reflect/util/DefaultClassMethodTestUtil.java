package au.net.netstorm.boost.sniper.reflect.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;

// FIX 1887 We need this ... I think.

// SUGGEST: Move into production.
public final class DefaultClassMethodTestUtil implements ClassMethodTestUtil {
    private final Set exclusions = new HashSet();
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private ArrayMaster master = new DefaultArrayMaster();

    {
        init();
    }

    private void init() {
        exlusionsForObject();
        exclusionsForProxy();
    }

    public Method[] getAll(Class cls) {
        return cls.getDeclaredMethods();
    }

    public Method[] getAllPublicInstance(Class cls) {
        Set<Method> result = getAllAsSet(cls);
        keepPublicInstance(result);
        return methods(result);
    }

    public Method[] getAllNonInherited(Class cls) {
        Set<Method> result = getAllAsSet(cls);
        keepNonInherited(result);
        return methods(result);
    }

    public Method[] getAllNotInheritedPublicInstance(Class cls) {
        Set<Method> result = getAllAsSet(cls);
        keepNonInherited(result);
        keepPublicInstance(result);
        return methods(result);
    }

    private Set<Method> getAllAsSet(Class cls) {
        Method[] all = cls.getDeclaredMethods();
        List<Method> list = Arrays.asList(all);
        return new HashSet<Method>(list);
    }

    private void keepPublicInstance(Set<Method> set) {
        Method[] methods = methods(set);
        for (Method method : methods) {
            keepPublicInstance(set, method);
        }
    }

    private void keepNonInherited(Set<Method> set) {
        Method[] methods = methods(set);
        for (Method method : methods) {
            keepNonInherited(set, method);
        }
    }

    private void keepPublicInstance(Set<Method> set, Method method) {
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

    private Method[] methods(Set<Method> set) {
        return master.toArray(set, Method.class);
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
