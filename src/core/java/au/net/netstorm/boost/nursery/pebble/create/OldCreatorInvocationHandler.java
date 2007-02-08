package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class OldCreatorInvocationHandler implements InvocationHandler {
    private OldCreator creator;

    public OldCreatorInvocationHandler(OldCreator creator) {
        this.creator = creator;
    }

    /*

        public CreatorInvocationHandler(GenericCreator genericCreator, Class implClass) {
            this.genericCreator = genericCreator;
            this.implClass = implClass;
        }

    */
    // FIX 1665 If we added a line like "if (!method.getName().equals("create")) barf();"
    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        // FIX BREADCRUMB 1665 -10 Use the Creator name to determine the create type.
        // FIX 1665 We'll need to pass in the impl type?
        // FIX BREADCRUMB 1665 -10 Do not use the return type.
        Class returnType = method.getReturnType();
        return creator.create(returnType, params);
    }
}
