package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface ModifierTestChecker {
    void checkSynchronized(Method method);

    void checkPublic(Class cls);

    void checkFinal(Class cls);

    void checkSynchronized(Class cls);
}
