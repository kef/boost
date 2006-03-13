package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.DefaultExceptionTestUtil;
import au.net.netstorm.boost.reflect.ExceptionTestUtil;
import au.net.netstorm.boost.util.fixture.InstanceProvider;
import au.net.netstorm.boost.util.fixture.InstanceProviderTestUtil;
import junit.framework.Assert;

// FIXME: SC523 Pull in latest external changes.
public final class NullParameterTestChecker {
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();
    private static final ExceptionTestUtil EXCEPTION_TEST_UTIL = new DefaultExceptionTestUtil();

    // FIXME: SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    // FIXME: SC523 Rename additional.
    public void checkNullConstructorParameters(Constructor constructor, Class[] parameterTypes, InstanceProvider additional) {
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isPrimitive()) {
                checkNullParameter(constructor, parameterTypes, i, additional);
            }
        }
    }

    private void checkNullParameter(Constructor constructor, Class[] parameterTypes, int currentParameter, InstanceProvider additional) {
        Object[] parameters = getParamsWithNull(parameterTypes, currentParameter, additional);
        try {
            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
            Class parameterType = parameterTypes[currentParameter];
            String message = "NULLs are evil!!! This object allows null for argument number " + (currentParameter + 1) +
                    " of type " + parameterType;
            Assert.fail(message);
        } catch (RuntimeException e) {
            checkExpected(e);
        }
    }

    private void checkExpected(RuntimeException e) {
        if (!isExpected(e)) throw e;
    }

    private Object[] getParamsWithNull(Class[] parameterTypes, int currentParameter, InstanceProvider additional) {
        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(parameterTypes, additional);
        parameters[currentParameter] = null;
        return parameters;
    }

    private boolean isExpected(RuntimeException e) {
        Class cls = EXCEPTION_TEST_UTIL.getRealExceptionClass(e); // FIXME: SC050 Is this needed?
        return isIllegalArgumentException(cls);
    }

    private boolean isIllegalArgumentException(Class cls) {
        return cls.equals(IllegalArgumentException.class);
    }
}
