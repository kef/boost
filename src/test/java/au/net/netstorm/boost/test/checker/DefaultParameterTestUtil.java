package au.net.netstorm.boost.test.checker;

import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.util.instance.InstanceProvider;

// FIXME: SC523 What to do with this class?
// FIXME: SC523 Instance-ise.
// FIXME: SC600 BREADCRUMB ... Instancise.

final class DefaultParameterTestUtil implements ParameterTestUtil {
    public Object[] createParameterValuesWithNull(InstanceProvider instanceProvider, Class[] paramTypes, int paramToMakeNull) {
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramValues[i] = instanceProvider.newInstance(paramTypes[i]);
        }
        paramValues[paramToMakeNull] = null;
        return paramValues;
    }

    // FIXME: SC523 Rename...
    // FIXME: SC043 R This belongs somewhere else.
    public void invokeBlock(Call invokeBlock) {
        try {
            invokeBlock.execute();
        } catch (EdgeException e) {
            handleException(e);
        }
    }

    private void handleException(EdgeException e) {
        Throwable cause = e.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable realCause = cause.getCause();
            rethrowException(realCause);
        }
    }

    private void rethrowException(Throwable realCause) {
        if (realCause instanceof IllegalArgumentException) {
            throw (IllegalArgumentException) realCause;
        } else {
            throw new RuntimeException(realCause);
        }
    }
}
