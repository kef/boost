/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

// FIXME: SC042 Tidy this.
// FIXME: SC042 Rename to Modifier to match the jdk.

public final class DefaultModifierTestUtil implements ModifierTestUtil {
    private static final String[] EXCLUSIONS = {"hashCode", "getClass", "equals", "toString", "wait", "notify", "notifyAll"};

    public boolean isPublic(Method method) {
        int modifiers = method.getModifiers();
        return Modifier.isPublic(modifiers);
    }

    public boolean isPublicInstance(Method method) {
        boolean isStatic = isStatic(method);
        if (isStatic) return false;
        return isPublic(method);
    }

    public boolean isFinal(Method method) {
        int modifiers = method.getModifiers();
        return isFinal(modifiers);
    }

    public boolean isStatic(Method method) {
        int modifiers = method.getModifiers();
        return isStatic(modifiers);
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

    public void checkFinal(Class cls) {
        Assert.assertTrue(isFinal(cls));
    }

    public void checkPublic(Class cls) {
        Assert.assertTrue(isPublic(cls));
    }

    // FIXME: SC042 Tidy the section below up.

    // FIXME: SC042 Expose via interface.
    // FIXME: SC042 Merge with existing functionality.
    // FIXME: SC042 Given the current state of affairs, this looks like it belongs in ClassPropertiesTestUtil.
    public void checkSynchronized(Class type) {
        Method[] methods = type.getMethods();
        for (int i = 0; i < methods.length; i++) {
            checkSynchronized(methods[i]);
        }
    }

    private void checkSynchronized(Method method) {
        String name = method.getName();
        if (isExclusion(name)) return;
        int modifiers = method.getModifiers();
        Assert.assertTrue("" + method, Modifier.isSynchronized(modifiers));
    }

    private boolean isExclusion(String methodName) {
        for (int i = 0; i < EXCLUSIONS.length; i++) {
            if (methodName.equals(EXCLUSIONS[i])) return true;
        }
        return false;
    }

    // FIXME: SC042 Remove dupe here.  See DefaultClassTestUtil.
    private boolean isFinal(int modifiers) {
        return Modifier.isFinal(modifiers);
    }

    private boolean isPublic(int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    private boolean isStatic(int modifiers) {
        return Modifier.isStatic(modifiers);
    }

    private boolean isAbstract(int modifiers) {
        return Modifier.isAbstract(modifiers);
    }
}
