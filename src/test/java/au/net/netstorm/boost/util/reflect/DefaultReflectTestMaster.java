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
    private final ClassTestUtil classer = new DefaultClassTestUtil();
    private final MethodTestUtil methods = new DefaultMethodTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        return classer.isImplementationOf(targetInterface, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return classer.isSubclassOf(superClass, subClass);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        return methods.invoke(invokee, methodName, parameters);
    }

    public Class getThrowsType(Method method) {
        return methods.getThrowsType(method);
    }

    public Field getDeclared(Class cls, String fieldName) {
        return fielder.getDeclared(cls, fieldName);
    }

    public Object getStatic(Class cls, String fieldName) {
        return fielder.getStatic(cls, fieldName);
    }

    public Object getInstance(Object ref, String fieldName) {
        return fielder.getInstance(ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object value) {
        fielder.setInstance(ref, fieldName, value);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValueSpec) {
        fielder.setInstance(ref, fieldValueSpec);
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
