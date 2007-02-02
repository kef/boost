package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class DefaultCreatorInvocationHandler implements InvocationHandler {
    private Creator creator;

    public DefaultCreatorInvocationHandler(Creator creator) {
        this.creator = creator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        Class returnType = method.getReturnType();
        return creator.create(returnType, objects);
    }
}
