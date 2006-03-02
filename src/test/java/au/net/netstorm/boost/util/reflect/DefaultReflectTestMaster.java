package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultReflectTestMaster implements ReflectTestMaster {
    private final ReflectTestUtil util = new DefaultReflectTestUtil();
    private final ReflectTestChecker checker = new DefaultReflectTestChecker();

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        return util.isImplementationOf(targetInterface, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return util.isSubclassOf(superClass, subClass);
    }

    public Object newInstance(Class type) {
        return util.newInstance(type);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        return invoke(invokee, methodName, parameters);
    }

    public Class getThrowsType(Method method) {
        return util.getThrowsType(method);
    }

    public Field getDeclared(Class cls, String fieldName) {
        return util.getDeclared(cls, fieldName);
    }

    public Object getStatic(Class cls, String fieldName) {
        return util.getStatic(cls, fieldName);
    }

    public Object getInstance(Object ref, String fieldName) {
        return util.getInstance(ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object value) {
        util.setInstance(ref, fieldName, value);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValue) {
        util.setInstance(ref, fieldValue);
    }

    public void setStatic(Class cls, String fieldName, Object value) {
        setStatic(cls, fieldName, value);
    }

    public void setStatic(Class cls, FieldValueSpec fieldValue) {
        setStatic(cls, fieldValue);
    }

    public Class getRealExceptionClass(Throwable t) {
        return util.getRealExceptionClass(t);
    }

    public boolean isPublic(Method method) {
        return util.isPublic(method);
    }

    public boolean isPublicInstance(Method method) {
        return util.isPublicInstance(method);
    }

    public boolean isFinal(Method method) {
        return util.isFinal(method);
    }

    public boolean isStatic(Method method) {
        return util.isStatic(method);
    }

    public boolean isSynchronized(Method method) {
        return util.isSynchronized(method);
    }

    public boolean isPublic(Class cls) {
        return util.isPublic(cls);
    }

    public boolean isFinal(Class cls) {
        return util.isFinal(cls);
    }

    public boolean isAbstract(Class cls) {
        return util.isAbstract(cls);
    }

    public boolean isConcrete(Class cls) {
        return util.isConcrete(cls);
    }

    public boolean isInterface(Class cls) {
        return isInterface(cls);
    }

    public boolean isSynchronized(Class cls) {
        return util.isSynchronized(cls);
    }

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        checker.checkImplementsAndFinal(expectedInterface, cls);
    }

    public void checkImplementsAndFinal(Class targetInterface, Class implementationClass) {
        checker.checkImplementsAndFinal(targetInterface, implementationClass);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        checker.checkSubclassOf(superClass, subClass);
    }

    public void checkSubclassOf(Class expectedImpl, Object ref) {
        checker.checkSubclassOf(expectedImpl, ref);
    }

    public void checkSynchronized(Class cls) {
        checker.checkSynchronized(cls);
    }

    public void checkPrivateFinalField(Class type, String fieldName) {
        checker.checkPrivateFinalField(type, fieldName);
    }

    public void checkType(Class expectedClass, Object ref, String fieldName) {
        checker.checkType(expectedClass, ref, fieldName);
    }

    public void checkFinal(Method method) {
        checker.checkFinal(method);
    }

    public void checkSynchronized(Method method) {
        checker.checkSynchronized(method);
    }

    public void checkPublic(Class cls) {
        checker.checkPublic(cls);
    }

    public void checkFinal(Class cls) {
        checker.checkFinal(cls);
    }

    public void checkConcrete(Class cls) {
        checker.checkConcrete(cls);
    }
}
