package au.net.netstorm.boost.nursery.reflect.checker;

import java.lang.reflect.InvocationTargetException;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;

public final class DefaultParameterTestUtil implements ParameterTestUtil {

    public Object[] createBadParamValues(InstanceProvider instanceProvider, Class[] paramTypes,
            int indexOfParamToMakeBad, Object badValue) {
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramValues[i] = instanceProvider.newInstance(paramTypes[i]);
        }
        setBadParam(paramValues, paramTypes, indexOfParamToMakeBad, badValue);
        return paramValues;
    }

    public void handleException(EdgeException e) {
        Throwable cause = e.getCause();
        if (cause instanceof InvocationTargetException) {
            Throwable realCause = cause.getCause();
            rethrowException(realCause);
        }
    }

    private void setBadParam(Object[] paramValues, Class[] paramTypes, int indexOfParamToMakeBad, Object badValue) {
        if (badValue == null) {
            paramValues[indexOfParamToMakeBad] = badValue;
        } else if (badValue.getClass().isAssignableFrom(paramTypes[indexOfParamToMakeBad])) {
            paramValues[indexOfParamToMakeBad] = badValue;
        } else {
            throw new RuntimeException("Expected value '" + badValue + "' to be of type " +
                    paramTypes[indexOfParamToMakeBad].getSimpleName());
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
