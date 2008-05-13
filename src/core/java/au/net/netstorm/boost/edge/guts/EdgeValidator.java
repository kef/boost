package au.net.netstorm.boost.edge.guts;

// FIX 2328 adding eager validator
public interface EdgeValidator {
    void validateEdge(Class<?> edge, Class<?> real);
}
