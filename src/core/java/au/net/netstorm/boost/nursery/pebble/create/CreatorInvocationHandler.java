package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class CreatorInvocationHandler implements InvocationHandler {
    private GenericCreator genericCreator;

    public CreatorInvocationHandler(GenericCreator genericCreator) {
        this.genericCreator = genericCreator;
    }

    // FIX 1665 If we added a line like "if (!method.getName().equals("create")) barf();"
    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        // FIX BREADCRUMB 1665 -10000 Use the Creator name to determine the create type.
        // FIX BREADCRUMB 1665 -10000 Do not use the return type.
        Class returnType = method.getReturnType();
        return genericCreator.create(returnType, params);
    }
}
