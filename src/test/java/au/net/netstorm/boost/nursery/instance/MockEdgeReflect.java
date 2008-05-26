package au.net.netstorm.boost.nursery.instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.exception.NotImplementedException;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

class MockEdgeReflect implements EdgeClass {
    private Object result;
    private Class cls;

    public void prepare(Object result) {
        this.result = result;
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Field getField(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Field[] getDeclaredFields(Class cls) {
        throw new NotImplementedException();
    }

    public <T> T newInstance(Class<? extends T> cls) {
        this.cls = cls;
        return (T) result;
    }

    public Constructor getConstructor(Class cls, Class[] parameterTypes) {
        throw new NotImplementedException();
    }

    public Class forName(String className) {
        throw new NotImplementedException();
    }

    public Method getMethod(Class cls, String methodName, Class[] parameterTypes) {
        throw new NotImplementedException();
    }

    public Method getDeclaredMethod(Class cls, String methodName, Class[] parameterTypes) {
        throw new NotImplementedException();
    }

    public Class getCls() {
        return cls;
    }
}
