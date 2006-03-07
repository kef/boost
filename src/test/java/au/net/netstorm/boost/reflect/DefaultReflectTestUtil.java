package au.net.netstorm.boost.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

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

    public boolean isPublic(Member member) {
        return modifierUtil.isPublic(member);
    }

    public boolean isPrivate(Member member) {
        return modifierUtil.isPrivate(member);
    }

    public boolean isPublicInstance(Member member) {
        return modifierUtil.isPublicInstance(member);
    }

    public boolean isFinal(Member member) {
        return modifierUtil.isFinal(member);
    }

    public boolean isStatic(Member member) {
        return modifierUtil.isStatic(member);
    }

    public boolean isInstance(Member member) {
        return modifierUtil.isInstance(member);
    }

    public boolean isSynchronized(Member member) {
        return modifierUtil.isSynchronized(member);
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
