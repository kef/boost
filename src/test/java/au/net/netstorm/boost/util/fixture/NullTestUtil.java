package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import junit.framework.Assert;
import au.net.netstorm.boost.util.reflect.DefaultReflectTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;

// FIXME: SC509 ? delete or instancise.
// FIXME: SC042 ? Make public or private.
class NullTestUtil {
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();
    private static final ReflectTestUtil REFLECTOR = new DefaultReflectTestUtil();

    // FIXME: SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    public static void checkNullParameters(Constructor constructor, Class[] parameters, InstanceProvider additional) {
        for (int i = 0; i < parameters.length; i++) {
            checkNullParameter(i, constructor, parameters, additional);
        }
    }

    private static void checkNullParameter(int i, Constructor constructor, Class[] paramTypes, InstanceProvider additional) {
        Object[] params = getParamsWithNull(i, paramTypes, additional);
        try {
            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, params);
            Assert.fail("NULLs are evil!!! This object allows null for argument number " + (i + 1) + " of type " + paramTypes[i]);
        } catch (RuntimeException e) {
            checkExpected(e);
        }
    }

    private static void checkExpected(RuntimeException e) {
        if (!isExpected(e)) throw e;
    }

    private static Object[] getParamsWithNull(int i, Class[] paramTypes, InstanceProvider additional) {
        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(paramTypes, additional);
        parameters[i] = null;
        return parameters;
    }

    private static boolean isExpected(RuntimeException e) {
        Class cls = REFLECTOR.getRealExceptionClass(e); // FIXME: SC050 Is this needed?
        return isIllegalArgumentException(cls);
    }

    private static boolean isIllegalArgumentException(Class cls) {
        return cls.equals(IllegalArgumentException.class);
    }
}
