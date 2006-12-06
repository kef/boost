package au.net.netstorm.boost.edger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class EdgifierFactoryInvocationHandler implements InvocationHandler {
    private final Class edgeType;

    public EdgifierFactoryInvocationHandler(Class edgeType) {
        this.edgeType = edgeType;
    }

    // FIX 1624 Deal with parameters being edge or non-edge
    public Object invoke(Object object, Method edgeMethod, Object[] parameters) throws Throwable {
//        // FIX 1624 Check incoming method call matches a method on the non-edge fella.
//        String edgeMethodName = edgeMethod.getName();
//        Class[] parameterTypes = getTypes(parameters);
//        // FIX 29228 Got to get the underlying implementation here.
//        Method targetMethod = edgeType.getMethod(edgeMethodName, parameterTypes);
//        return targetMethod.invoke(parameters);
        return null;
    }

//    // FIX 1624 Does this belong in some introspector helper?
//    private Class[] getTypes(Object[] objects) {
//        int length = objects.length;
//        Class[] result = new Class[length];
//        for (int i = 0; i < length; i++) {
//            result[i] = objects[i].getClass();
//        }
//        return result;
//    }
}
