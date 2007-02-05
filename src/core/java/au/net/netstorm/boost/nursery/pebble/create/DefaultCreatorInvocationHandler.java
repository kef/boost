package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class DefaultCreatorInvocationHandler implements InvocationHandler {
    private GenericCreator genericCreator;

    public DefaultCreatorInvocationHandler(GenericCreator genericCreator) {
        this.genericCreator = genericCreator;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        Class returnType = method.getReturnType();
        return genericCreator.create(returnType, params);
    }
}
