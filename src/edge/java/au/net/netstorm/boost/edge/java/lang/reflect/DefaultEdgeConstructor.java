package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.IllegalEdgeConstructorArgumentException;

// FIX DEBT We don't do logic in edges.
public final class DefaultEdgeConstructor implements EdgeConstructor {
    private final String linefeed = System.getProperty("line.separator");

    public Object newInstance(Constructor constructor, Object[] args) {
        try {
            return constructor.newInstance(args);
        } catch (Exception e) {
            String error = error(constructor, args);
            if (e instanceof IllegalArgumentException)
                throw new IllegalEdgeConstructorArgumentException(error, e);
            throw new EdgeException(error, e);
        }
    }

    private String error(Constructor constructor, Object[] args) {
        String result = constructor + linefeed;
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                result += args[i] + linefeed;
            }
        }
        return result;
    }
}

