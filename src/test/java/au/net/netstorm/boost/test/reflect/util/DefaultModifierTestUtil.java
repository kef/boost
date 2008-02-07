package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class DefaultModifierTestUtil implements ModifierTestUtil {
    public boolean isPublic(Member member) {
        int modifiers = getModifiers(member);
        return Modifier.isPublic(modifiers);
    }

    public boolean isProtected(Member member) {
        int modifiers = getModifiers(member);
        return Modifier.isProtected(modifiers);
    }

    public boolean isPrivate(Member member) {
        int modifiers = getModifiers(member);
        return Modifier.isPrivate(modifiers);
    }

    public boolean isPublicInstance(Member member) {
        boolean isStatic = isStatic(member);
        if (isStatic) return false;
        return isPublic(member);
    }

    public boolean isFinal(Member member) {
        int modifiers = getModifiers(member);
        return isFinal(modifiers);
    }

    public boolean isStatic(Member member) {
        int modifiers = getModifiers(member);
        return isStatic(modifiers);
    }

    public boolean isInstance(Member member) {
        return !isStatic(member);
    }

    public boolean isSynchronized(Member member) {
        int modifiers = getModifiers(member);
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

    public boolean isConcrete(Class cls) {
        return !isAbstract(cls);
    }

    public boolean isInterface(Class cls) {
        int modifiers = cls.getModifiers();
        return isInterface(modifiers);
    }

    public boolean isSynchronized(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (isPublicAndNotSynchronized(methods[i])) return false;
        }
        return true;
    }

    private boolean isPublicAndNotSynchronized(Method method) {
        int modifiers = method.getModifiers();
        return isPublic(modifiers) && !isSynchronized(method);
    }

    private boolean isPublic(int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    private boolean isFinal(int modifiers) {
        return Modifier.isFinal(modifiers);
    }

    private boolean isStatic(int modifiers) {
        return Modifier.isStatic(modifiers);
    }

    private boolean isAbstract(int modifiers) {
        return Modifier.isAbstract(modifiers);
    }

    private boolean isInterface(int modifiers) {
        return Modifier.isInterface(modifiers);
    }

    private boolean isSynchronized(int modifiers) {
        return Modifier.isSynchronized(modifiers);
    }

    private int getModifiers(Member member) {
        return member.getModifiers();
    }
}
