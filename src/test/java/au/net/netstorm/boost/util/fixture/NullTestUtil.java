package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import junit.framework.Assert;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;

// FIXME: SC501 ? delete.
class NullTestUtil {
    static void checkNullParameters(Constructor constructor, Class[] argTypes, int numOfParams) {
        for (int i = 0; i < numOfParams; i++) {
            checkNullParameter(argTypes, i, constructor);
        }
    }

    private static void checkNullParameter(Class[] argTypes, int i, Constructor constructor) {
        Object[] parameters = getParamsWithNull(argTypes, i);
        try {
            InstanceProviderTestUtil.getInstance(constructor, parameters);
            Assert.fail("NULLs are evil!!! This object allows null for argument number " + (i + 1) + " of type " + argTypes[i]);
        } catch (RuntimeException e) {
            if (!isExpectedException(e)) throw e;
        }
    }

    private static Object[] getParamsWithNull(Class[] argTypes, int i) {
        Object[] parameters = InstanceProviderTestUtil.getInstances(argTypes);
        parameters[i] = null;
        return parameters;
    }

    private static boolean isExpectedException(RuntimeException e) {
        Class realExceptionClass = ReflectTestUtil.getRealExceptionClass(e);
        return ((realExceptionClass == IllegalArgumentException.class) ||
                (realExceptionClass == NullPointerException.class));
    }
}
