package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// FIXME: SC042 Tidy this.
// FIXME: SC042 Rename to Modifier to match the jdk.

// FIXME: SC042 Remove check* methods.

public final class DefaultModifierTestUtil implements ModifierTestUtil {
    public boolean isPublic(Method method) {
        int modifiers = getModifiers(method);
        return Modifier.isPublic(modifiers);
    }

    public boolean isPublicInstance(Method method) {
        boolean isStatic = isStatic(method);
        if (isStatic) return false;
        return isPublic(method);
    }

    public boolean isFinal(Method method) {
        int modifiers = getModifiers(method);
        return isFinal(modifiers);
    }

    public boolean isStatic(Method method) {
        int modifiers = getModifiers(method);
        return isStatic(modifiers);
    }

    public boolean isSynchronized(Method method) {
        int modifiers = getModifiers(method);
        return isSynchronized(modifiers);
    }

    public boolean isPublic(Class cls) {
        int modifiers = cls.getModifiers();
        return isPublic(modifiers);
    }

    public boolean isFinal(Class cls) {
        int modifiers = cls.getModifiers();
        return isFinal(modifiers);
    }

    public boolean isAbstract(Class cls) {
        int modifiers = cls.getModifiers();
        return isAbstract(modifiers);
    }

    public boolean isSynchronized(Class cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (!isSynchronized(methods[i])) return false;
        }
        return true;
    }

    private boolean isPublic(int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    // FIXME: SC042 Remove dupe here.  See DefaultClassTestUtil.
    private boolean isFinal(int modifiers) {
        return Modifier.isFinal(modifiers);
    }

    private boolean isStatic(int modifiers) {
        return Modifier.isStatic(modifiers);
    }

    private boolean isSynchronized(int modifiers) {
        return Modifier.isSynchronized(modifiers);
    }

    private boolean isAbstract(int modifiers) {
        return Modifier.isAbstract(modifiers);
    }

    // FIXME: SC042 Bottom
    private int getModifiers(Method method) {
        return method.getModifiers();
    }
}
