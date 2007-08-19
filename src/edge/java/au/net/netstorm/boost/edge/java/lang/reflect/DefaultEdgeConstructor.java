package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.IllegalEdgeConstructorArgumentException;

public final class DefaultEdgeConstructor implements EdgeConstructor {
    private final String newLine = System.getProperty("line.separator");

    public Object newInstance(Constructor constructor, Object[] initArgs) {
        try {
            return constructor.newInstance(initArgs);
        } catch (Exception e) {
            String errorString = createErrorString(constructor, initArgs);
            if (e instanceof IllegalArgumentException)
                throw new IllegalEdgeConstructorArgumentException(errorString, e);
            throw new EdgeException(errorString, e);
        }
    }

    private String createErrorString(Constructor constructor, Object[] initArgs) {
        String errorString = constructor + newLine;
        if (initArgs != null) {
            for (int i = 0; i < initArgs.length; i++) {
                errorString += initArgs[i] + newLine;
            }
        }
        return errorString;
    }
}

