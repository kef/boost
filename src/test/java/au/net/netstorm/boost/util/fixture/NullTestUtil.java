package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.DefaultExceptionTestUtil;
import au.net.netstorm.boost.reflect.ExceptionTestUtil;
import junit.framework.Assert;

// FIXME: SC517 Is this really a NullTestUtil?

public final class NullTestUtil {
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();
    private static final ExceptionTestUtil exceptions = new DefaultExceptionTestUtil();

    // FIXME: SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    public void checkNullParameters(Constructor constructor, Class[] parameters, InstanceProvider additional) {
        for (int i = 0; i < parameters.length; i++) {
            checkNullParameter(i, constructor, parameters, additional);
        }
    }

    private void checkNullParameter(int i, Constructor constructor, Class[] paramTypes, InstanceProvider additional) {
        Object[] params = getParamsWithNull(i, paramTypes, additional);
        try {
            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, params);
            Assert.fail("NULLs are evil!!! This object allows null for argument number " + (i + 1) + " of type " + paramTypes[i]);
        } catch (RuntimeException e) {
            checkExpected(e);
        }
    }

    private void checkExpected(RuntimeException e) {
        if (!isExpected(e)) throw e;
    }

    private Object[] getParamsWithNull(int i, Class[] paramTypes, InstanceProvider additional) {
        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(paramTypes, additional);
        parameters[i] = null;
        return parameters;
    }

    private boolean isExpected(RuntimeException e) {
        Class cls = exceptions.getRealExceptionClass(e); // FIXME: SC050 Is this needed?
        return isIllegalArgumentException(cls);
    }

    private boolean isIllegalArgumentException(Class cls) {
        return cls.equals(IllegalArgumentException.class);
    }
}
