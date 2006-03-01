package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface ModifierTestUtil {
    boolean isPublic(Method method);

    boolean isPublicInstance(Method method);

    boolean isFinal(Method method);

    boolean isStatic(Method method);

    boolean isSynchronized(Method method);

    boolean isPublic(Class cls);

    boolean isFinal(Class cls);

    boolean isAbstract(Class cls);

    boolean isConcrete(Class cls);

    boolean isInterface(Class cls);

    boolean isSynchronized(Class cls);
}
