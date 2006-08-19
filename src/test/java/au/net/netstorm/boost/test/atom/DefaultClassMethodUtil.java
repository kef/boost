package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// FIX SC600 Candidate for reflect.util.

final class DefaultClassMethodUtil implements ClassMethodUtil {
    // FUTURE: This only works for classes which inherit java.lang.Object (or Primordial).  Should work for all classes.
    private final Set inherited = new HashSet();
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    {
        inherited.add("toString");
        inherited.add("hashCode");
        inherited.add("equals");
    }

    public Method[] getAll(Class cls) {
        return cls.getDeclaredMethods();
    }

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
        HashSet result = getAllAsSet(cls);
        keepNonInherited(result);
        keepPublicInstance(result);
        return methods(result);
    }

    private HashSet getAllAsSet(Class cls) {
        Method[] all = getAll(cls);
        List list = Arrays.asList(all);
        return new HashSet(list);
    }

    private void keepPublicInstance(Set set) {
        Method[] methods = methods(set);
        for (int i = 0; i < methods.length; i++) keepPublicInstance(set, methods[i]);
    }

    private void keepNonInherited(Set set) {
        Method[] methods = methods(set);
        for (int i = 0; i < methods.length; i++) keepNonInherited(set, methods[i]);
    }

    private void keepPublicInstance(Set set, Method method) {
        if (!modifierUtil.isPublicInstance(method)) set.remove(method);
    }

    private void keepNonInherited(Set set, Method method) {
        String name = method.getName();
        if (inherited.contains(name)) set.remove(method);
    }

    private Method[] methods(Set set) {
        return (Method[]) set.toArray(new Method[]{});
    }
}
