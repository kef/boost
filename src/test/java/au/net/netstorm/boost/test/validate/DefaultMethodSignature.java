package au.net.netstorm.boost.test.validate;

import au.net.netstorm.boost.primordial.Primordial;

import java.lang.reflect.Method;

class DefaultMethodSignature extends Primordial implements MethodSignature {
    private final Class[] params;
    private final Class returnValue;
    private final String name;

    public DefaultMethodSignature(Method method) {
        params = method.getParameterTypes();
        returnValue = method.getReturnType();
        name = method.getName();
    }
}
