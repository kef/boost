package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.exception.NotImplementedException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// FIX SC600 Candidate for reflect.util.

final class DefaultClassMethodUtil implements ClassMethodUtil {
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    public Method[] getAll(Class cls) {
        return cls.getDeclaredMethods();
    }

    public Method[] getAllPublicInstance(Class cls) {
        Method[] all = getAll(cls);
        List list = Arrays.asList(all);
        HashSet result = new HashSet(list);
        for (int i = 0; i < all.length; i++) {
            Method method = all[i];
            if (!modifierUtil.isPublicInstance(method)) result.remove(method);
        }
        return (Method[]) result.toArray(new Method[]{});
    }

    public Method[] getAllNonInherited(Class cls) {
        throw new NotImplementedException();
    }

    public Method[] getAllNotInheritedPublicInstance(Class cls) {
        throw new NotImplementedException();
    }
}
