package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;

public final class DefaultEdgeValidator implements EdgeValidator {

    public void validateEdge(Class<?> edge, Class<?> real) {
        Method[] edges = edge.getMethods();
        for (int i = 0; i < edges.length; ++i) {
            validate(edges[0], real);
        }
    }

    private void validate(Method method, Class<?> real) {

    }
}
