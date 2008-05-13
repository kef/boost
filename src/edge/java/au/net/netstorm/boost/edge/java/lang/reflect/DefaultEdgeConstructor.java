package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.guts.EdgeException;
import au.net.netstorm.boost.edge.guts.IllegalEdgeConstructorArgumentException;

// FIX 2328 MAG Not sure why the logic is here?
public final class DefaultEdgeConstructor implements EdgeConstructor {
    private final String linefeed = System.getProperty("line.separator");

    public <T> T newInstance(Constructor<T> constructor, Object[] args) {
        try {
            return constructor.newInstance(args);
        } catch (Exception e) {
            String error = error(constructor, args);
            if (e instanceof IllegalArgumentException)
                throw new IllegalEdgeConstructorArgumentException(error, e);
            throw new EdgeException(error, e);
        }
    }

    private String error(Constructor<?> constructor, Object[] args) {
        String seed = constructor + linefeed;
        return (args == null) ? seed : error(args, seed);
    }

    private String error(Object[] args, String seed) {
        String result = seed;
        for (int i = 0; i < args.length; i++) {
            result += args[i] + linefeed;
        }
        return result;
    }
}

