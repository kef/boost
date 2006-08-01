package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Method;

// FIX SC600 Move all these methods out.

public interface EdgeReflect {
    // FIX SC600 EdgeMethod.
    Object invoke(Method method, Object instance);
}
