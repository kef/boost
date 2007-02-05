package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class DefaultCreatorInvocationHandler implements InvocationHandler {
    private MegaCreator megaCreator;

    public DefaultCreatorInvocationHandler(MegaCreator megaCreator) {
        this.megaCreator = megaCreator;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        Class returnType = method.getReturnType();
        return megaCreator.create(returnType, params);
    }
}
