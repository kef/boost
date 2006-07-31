package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.EdgeException;

// FIX SC600 BREADCRUMB MrDavis Get back in here!!!!
// FIX SC600 Remove.
// FIX SC600 How about EdgeField and EdgeClass.
// FIX SC600 EdgeClassFactory for obtaining classes.
// FIX SC600 Remove duplication shared with EdgeMethod.

public final class OldEdgeReflect implements EdgeReflect {
    public Object getFieldValue(Field field, Object ref) {
        try {
            return field.get(ref);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    public void setFieldValue(Field field, Object ref, Object value) {
        try {
            field.set(ref, value);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    // FIX SC600 This goes to EdgeConstructor.
    public Object newInstance(Constructor constructor, Object[] parameters) {
        try {
            return constructor.newInstance(parameters);
        } catch (InstantiationException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        } catch (InvocationTargetException e) {
            throw new EdgeException(e);
        }
    }

    public Object invoke(Method method, Object instance) {
        return invoke(method, instance, null);
    }

    public Object invoke(Method method, Object instance, Object[] args) {
        try {
            return method.invoke(instance, args);
        } catch (Exception e) {
            throw new EdgeException(e);
        }
    }
}
