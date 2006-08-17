package au.net.netstorm.boost.nursery.instance;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.util.exception.NotImplementedException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MockEdgeReflect implements EdgeClass {
    private Object result;
    private Class cls;

    public void prepare(Object result) {
        this.result = result;
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        throw new NotImplementedException();
    }

    public Object newInstance(Class cls) {
        this.cls = cls;
        return result;
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
