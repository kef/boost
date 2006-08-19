package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import junit.framework.Assert;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// FIX SC600 Candidate for reflect.util.

final class DefaultClassMethodUtil implements ClassMethodUtil {
    private final Set inherited = new HashSet();
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    {
        inherited.add("toString");
        inherited.add("hashCode");
        inherited.add("equals");
    }

    public Method[] getAll(Class cls) {
        return guardGetAll(cls);
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
        Method[] all = guardGetAll(cls);
        List list = Arrays.asList(all);
        return new HashSet(list);
    }

    private Method[] guardGetAll(Class cls) {
        if (!cls.equals(Primordial.class)) Assert.fail("Currently we only support Primordial.  You requested " + cls);
        return cls.getDeclaredMethods();
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
