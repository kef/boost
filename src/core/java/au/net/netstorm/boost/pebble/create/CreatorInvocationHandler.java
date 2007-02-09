package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class CreatorInvocationHandler implements InvocationHandler {
    private Creator creator;
    private Class implClass;

    public CreatorInvocationHandler(Creator creator, Class implClass) {
        this.creator = creator;
        this.implClass = implClass;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        return creator.create(implClass, params);
    }
}
