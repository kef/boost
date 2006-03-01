package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

import junit.framework.Assert;

public final class DefaultModifierTestChecker implements ModifierTestChecker {
    private static final String[] EXCLUSIONS = {"hashCode", "getClass", "equals", "toString", "wait", "notify", "notifyAll"};
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();

    public void checkFinal(Method method) {
        boolean isFinal = modifier.isFinal(method);
        check(method, isFinal);
    }

    public void checkSynchronized(Method method) {
        boolean isSynchronized = modifier.isSynchronized(method);
        check(method, isSynchronized);
    }

    public void checkPublic(Class cls) {
        boolean isPublic = modifier.isPublic(cls);
        check(cls, "is not public", isPublic);
    }

    public void checkFinal(Class cls) {
        boolean isFinal = modifier.isFinal(cls);
        check(cls, "is not final", isFinal);
    }

    // FIXME: SC042 This possibly belongs in DClassTU.  It definitely does.
    public void checkSynchronized(Class cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            checkSynchronizedIgnoringExclusions(methods[i]);
        }
    }

    public void checkConcrete(Class cls) {
        boolean isConcrete = modifier.isConcrete(cls);
        check(cls, "is not concrete", isConcrete);
    }

    private void checkSynchronizedIgnoringExclusions(Method method) {
        boolean isExclusion = isExclusion(method);
        if (isExclusion) return;
        checkSynchronized(method);
    }

    private boolean isExclusion(Method method) {
        String name = method.getName();
        return isExclusion(name);
    }

    private boolean isExclusion(String methodName) {
        for (int i = 0; i < EXCLUSIONS.length; i++) {
            if (methodName.equals(EXCLUSIONS[i])) return true;
        }
        return false;
    }

    private String getName(Method method) {
        return "" + method;
    }

    private String getName(Class cls) {
        return classMaster.getShortName(cls);
    }

    // FIXME: SC042 Add message to this method.
    private void check(Method method, boolean ok) {
        Assert.assertTrue(getName(method), ok);
    }

    private void check(Class cls, String comment, boolean ok) {
        String clsName = getName(cls);
        String message = clsName + " " + comment;
        Assert.assertTrue(message, ok);
    }
}
