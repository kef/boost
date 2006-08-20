package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.Method;

public interface ClassMethodTestUtil {
    Method[] getAll(Class cls);

    Method[] getAllPublicInstance(Class cls);

    Method[] getAllNonInherited(Class cls);

    Method[] getAllNotInheritedPublicInstance(Class cls);
}
