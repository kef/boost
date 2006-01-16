package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import junit.framework.Assert;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;

// FIXME: SC509 ? delete or instancise.
class NullTestUtil {
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();

    // FIXME: SC050 Given we're seeing a lot of the constructor/parameters together, isn't it about time to build an aggregate?
    static void checkNullParameters(Constructor constructor, Class[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            // FIXME: SC050 Can the following be tidied up easily.
            checkNullParameter(constructor, parameters, i);
        }
    }

    private static void checkNullParameter(Constructor constructor, Class[] types, int i) {
        Object[] parameters = getParamsWithNull(types, i);
        try {
            INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
            Assert.fail("NULLs are evil!!! This object allows null for argument number " + (i + 1) + " of type " + types[i]);
        } catch (RuntimeException e) {
            checkExpectedException(e);
        }
    }

    private static void checkExpectedException(RuntimeException e) {
        if (!isExpectedException(e)) throw e;
    }

    private static Object[] getParamsWithNull(Class[] argTypes, int i) {
        Object[] parameters = INSTANCE_PROVIDER_TEST_UTIL.getInstances(argTypes);
        parameters[i] = null;
        return parameters;
    }

    private static boolean isExpectedException(RuntimeException e) {
        Class cls = ReflectTestUtil.getRealExceptionClass(e); // FIXME: SC050 Is this needed?
        return (isIllegalArgumentException(cls)) || isNullPointerException(cls);
    }

    // FIXME: SC050 We want an IAE ... NOT A NPE
    private static boolean isNullPointerException(Class cls) {
//        return (cls == NullPointerException.class);
        return false;
    }

    private static boolean isIllegalArgumentException(Class cls) {
        return cls.equals(IllegalArgumentException.class);
    }
}
