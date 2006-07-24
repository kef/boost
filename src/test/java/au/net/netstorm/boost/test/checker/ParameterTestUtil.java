package au.net.netstorm.boost.test.checker;

import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.util.instance.InstanceProvider;

// FIXME: SC523 What to do with this class?
// FIXME: SC523 Instance-ise.

final class ParameterTestUtil {
    private static final DefaultAssertException ASSERT_EXCEPTION = new DefaultAssertException();

    static Object[] createParameterValuesWithNull(InstanceProvider instanceProvider, Class[] paramTypes, int paramToMakeNull) {
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramValues[i] = instanceProvider.newInstance(paramTypes[i]);
        }
        paramValues[paramToMakeNull] = null;
        return paramValues;
    }

    // FIXME: SC523 Rename...
    static void invokeBlock(Block invokeBlock) {
        try {
            invokeBlock.execute();
        } catch (EdgeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof InvocationTargetException) {
                throw (IllegalArgumentException) cause.getCause();
            }
        }
    }

    // FIXME SC523: Also check message here once null checks are consistent.
    static void checkExceptionIsIllegalArgumentException(Exception e) {
        ASSERT_EXCEPTION.checkExceptionClass(IllegalArgumentException.class, e);
    }
}
