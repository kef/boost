package au.net.netstorm.boost.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.exception.NotImplementedException;

public class MockReflectEdge implements ReflectEdge {
    private Object result;
    private Class cls;

    public void prepare(Object result) {
        this.result = result;
    }

    // FIXME: SC524 Fill out these unimplemented methods as required.
    public Object getFieldValue(Field field, Object ref) {
        throw new NotImplementedException();
    }

    public void setFieldValue(Field field, Object ref, Object value) {
        throw new NotImplementedException();
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Object newInstance(Class cls) {
        this.cls = cls;
        return result;
    }

    public Object newInstance(Constructor constructor, Object[] parameters) {
        throw new NotImplementedException();
    }

    public Class forName(String className) {
        throw new NotImplementedException();
    }

    public Method getMethod(Class cls, String methodName, Class[] parameterTypes) {
        throw new NotImplementedException();
    }

    public Object invoke(Method method, Object instance) {
        throw new NotImplementedException();
    }

    public Object invoke(Method method, Object instance, Object[] args) {
        throw new NotImplementedException();
    }

    public Class getCls() {
        return cls;
    }
}
