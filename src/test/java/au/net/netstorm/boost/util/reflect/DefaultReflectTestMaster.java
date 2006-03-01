package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 BREADCRUMB This is a pure delegation class.  Complete.

public final class DefaultReflectTestMaster implements ReflectTestMaster {
    private final ClassTestUtil classer = new DefaultClassTestUtil();

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        return classer.isImplementationOf(targetInterface, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return classer.isSubclassOf(superClass, subClass);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        throw new NotImplementedException();
    }

    public Class getThrowsType(Method method) {
        throw new NotImplementedException();
    }

    public Field getDeclared(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Object getStatic(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Object getInstance(Object ref, String fieldName) {
        throw new NotImplementedException();
    }

    public void setInstance(Object ref, String fieldName, Object value) {
        throw new NotImplementedException();
    }

    public void setInstance(Object ref, FieldValueSpec fieldValueSpec) {
        throw new NotImplementedException();
    }

    public void setStatic(Class cls, String fieldName, Object value) {
        throw new NotImplementedException();
    }

    public void setStatic(Class cls, FieldValueSpec fieldValueSpec) {
        throw new NotImplementedException();
    }

    public boolean isPublic(Method method) {
        throw new NotImplementedException();
    }

    public boolean isPublicInstance(Method method) {
        throw new NotImplementedException();
    }

    public boolean isFinal(Method method) {
        throw new NotImplementedException();
    }

    public boolean isStatic(Method method) {
        throw new NotImplementedException();
    }

    public boolean isSynchronized(Method method) {
        throw new NotImplementedException();
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
