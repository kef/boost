package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import junit.framework.Assert;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;

// FIXME: SC509 ? delete or instancise.
class NullTestUtil {
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();

    // FIXME: SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    static void checkNullParameters(Constructor constructor, Class[] parameters, int numOfParams) {
        Assert.assertEquals(parameters.length, numOfParams); // FIXME: SC050 ... Just a small check to ensure we can remove the numOfParams bollocks!!!!!!!!
        for (int i = 0; i < numOfParams; i++) {
            checkNullParameter(parameters, i, constructor);
        }
    }

    private static void checkNullParameter(Class[] argTypes, int i, Constructor constructor) {
        Object[] parameters = getParamsWithNull(argTypes, i);
        try {
            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
            Assert.fail("NULLs are evil!!! This object allows null for argument number " + (i + 1) + " of type " + argTypes[i]);
        } catch (RuntimeException e) {
            if (!isExpectedException(e)) throw e;
        }
    }

    private static Object[] getParamsWithNull(Class[] argTypes, int i) {
        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(argTypes);
        parameters[i] = null;
        return parameters;
    }

    private static boolean isExpectedException(RuntimeException e) {
        Class realExceptionClass = ReflectTestUtil.getRealExceptionClass(e);
        return ((realExceptionClass == IllegalArgumentException.class) ||
                (realExceptionClass == NullPointerException.class));
    }
}
