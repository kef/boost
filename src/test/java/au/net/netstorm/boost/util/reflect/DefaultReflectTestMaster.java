package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 Remove all NIE.  Delegate.

public final class DefaultReflectTestMaster implements ReflectTestMaster {
    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        throw new NotImplementedException();
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        throw new NotImplementedException();
    }

    public Object newInstance(Class type) {
        throw new NotImplementedException();
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

    public void setInstance(Object ref, FieldValueSpec fieldValue) {
        throw new NotImplementedException();
    }

    public void setStatic(Class cls, String fieldName, Object value) {
        throw new NotImplementedException();
    }

    public void setStatic(Class cls, FieldValueSpec fieldValue) {
        throw new NotImplementedException();
    }

    public Class getRealExceptionClass(Throwable t) {
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

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        throw new NotImplementedException();
    }

    public void checkImplementsAndFinal(Class targetInterface, Class implementationClass) {
        throw new NotImplementedException();
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        throw new NotImplementedException();
    }

    public void checkSubclassOf(Class expectedImpl, Object ref) {
        throw new NotImplementedException();
    }

    public void checkSynchronized(Class cls) {
        throw new NotImplementedException();
    }

    public void checkPrivateFinalField(Class type, String fieldName) {
        throw new NotImplementedException();
    }

    public void checkType(Class expectedClass, Object ref, String fieldName) {
        throw new NotImplementedException();
    }

    public void checkFinal(Method method) {
        throw new NotImplementedException();
    }

    public void checkSynchronized(Method method) {
        throw new NotImplementedException();
    }

    public void checkPublic(Class cls) {
        throw new NotImplementedException();
    }

    public void checkFinal(Class cls) {
        throw new NotImplementedException();
    }

    public void checkConcrete(Class cls) {
        throw new NotImplementedException();
    }
}
