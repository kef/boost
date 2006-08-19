package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Method;

interface ClassMethodUtil {
    Method[] getAll(Class cls);

    Method[] getAllPublicInstance(Class cls);

    Method[] getAllNonInherited(Class cls);

    Method[] getAllNotInheritedPublicInstance(Class cls);
}
