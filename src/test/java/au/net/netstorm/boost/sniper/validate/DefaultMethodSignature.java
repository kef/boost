package au.net.netstorm.boost.sniper.validate;

import au.net.netstorm.boost.bullet.primordial.Primordial;

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
