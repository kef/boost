package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 BREADCRUMB This is a pure delegation class.  Complete.
// FIXME: SC042 Make sure there are not NIE.

public final class DefaultReflectTestMaster implements ReflectTestMaster {
    // FIXME: SC042 Consistent names.
    private final ClassTestUtil cls = new DefaultClassTestUtil();
    private final MethodTestUtil method = new DefaultMethodTestUtil();
    private final FieldTestUtil field = new DefaultFieldTestUtil();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        return this.cls
                .isImplementationOf(targetInterface, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return cls.isSubclassOf(superClass, subClass);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        return method.invoke(invokee, methodName, parameters);
    }

    public Class getThrowsType(Method method) {
        return this.method
                .getThrowsType(method);
    }

    public Field getDeclared(Class cls, String fieldName) {
        return field.getDeclared(cls, fieldName);
    }

    public Object getStatic(Class cls, String fieldName) {
        return field.getStatic(cls, fieldName);
    }

    public Object getInstance(Object ref, String fieldName) {
        return field.getInstance(ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object value) {
        field.setInstance(ref, fieldName, value);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValueSpec) {
        field.setInstance(ref, fieldValueSpec);
    }

    public void setStatic(Class cls, String fieldName, Object value) {
        field.setStatic(cls, fieldName, value);
    }

    public void setStatic(Class cls, FieldValueSpec fieldValueSpec) {
        field.setStatic(cls, fieldValueSpec);
    }

    public boolean isPublic(Method method) {
        return modifier.isPublic(method);
    }

    public boolean isPublicInstance(Method method) {
        return modifier.isPublicInstance(method);
    }

    public boolean isFinal(Method method) {
        return modifier.isFinal(method);
    }

    public boolean isStatic(Method method) {
        return modifier.isStatic(method);
    }

    public boolean isSynchronized(Method method) {
        return modifier.isSynchronized(method);
    }

    public boolean isPublic(Class cls) {
        throw new NotImplementedException();
    }

    public boolean isFinal(Class cls) {
        throw new NotImplementedException();
    }

    public boolean isAbstract(Class cls) {
        throw new NotImplementedException();
    }

    public boolean isConcrete(Class cls) {
        throw new NotImplementedException();
    }

    public boolean isInterface(Class cls) {
        throw new NotImplementedException();
    }

    public boolean isSynchronized(Class cls) {
        throw new NotImplementedException();
    }

    public Class getRealExceptionClass(Throwable t) {
        throw new NotImplementedException();
    }
}
