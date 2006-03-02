package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 Rename to ReflectTestUtil.  Master should have checkers as well.

public final class DefaultReflectTestUtil implements ReflectTestUtil {
    private final ClassTestUtil clsUtil = new DefaultClassTestUtil();
    private final MethodTestUtil methodUtil = new DefaultMethodTestUtil();
    private final FieldTestUtil fieldUtil = new DefaultFieldTestUtil();
    private final ExceptionTestUtil exceptionUtil = new DefaultExceptionTestUtil();
    private final ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        return clsUtil.isImplementationOf(targetInterface, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return clsUtil.isSubclassOf(superClass, subClass);
    }

    public Object newInstance(Class type) {
        return clsUtil.newInstance(type);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        return methodUtil.invoke(invokee, methodName, parameters);
    }

    public Class getThrowsType(Method method) {
        return methodUtil.getThrowsType(method);
    }

    public Field getDeclared(Class cls, String fieldName) {
        return fieldUtil.getDeclared(cls, fieldName);
    }

    public Object getStatic(Class cls, String fieldName) {
        return fieldUtil.getStatic(cls, fieldName);
    }

    public Object getInstance(Object ref, String fieldName) {
        return fieldUtil.getInstance(ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object value) {
        fieldUtil.setInstance(ref, fieldName, value);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValue) {
        fieldUtil.setInstance(ref, fieldValue);
    }

    public void setStatic(Class cls, String fieldName, Object value) {
        fieldUtil.setStatic(cls, fieldName, value);
    }

    public void setStatic(Class cls, FieldValueSpec fieldValue) {
        fieldUtil.setStatic(cls, fieldValue);
    }

    public Class getRealExceptionClass(Throwable t) {
        return exceptionUtil.getRealExceptionClass(t);
    }

    public boolean isPublic(Method method) {
        return modifierUtil.isPublic(method);
    }

    public boolean isPublicInstance(Method method) {
        return modifierUtil.isPublicInstance(method);
    }

    public boolean isFinal(Method method) {
        return modifierUtil.isFinal(method);
    }

    public boolean isStatic(Method method) {
        return modifierUtil.isStatic(method);
    }

    public boolean isSynchronized(Method method) {
        return modifierUtil.isSynchronized(method);
    }

    public boolean isPublic(Class cls) {
        return modifierUtil.isPublic(cls);
    }

    public boolean isFinal(Class cls) {
        return modifierUtil.isFinal(cls);
    }

    public boolean isAbstract(Class cls) {
        return modifierUtil.isAbstract(cls);
    }

    public boolean isConcrete(Class cls) {
        return modifierUtil.isConcrete(cls);
    }

    public boolean isInterface(Class cls) {
        return modifierUtil.isInterface(cls);
    }

    public boolean isSynchronized(Class cls) {
        return modifierUtil.isSynchronized(cls);
    }
}
