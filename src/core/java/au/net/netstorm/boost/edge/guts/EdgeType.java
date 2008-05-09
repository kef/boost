package au.net.netstorm.boost.edge.guts;

// FIX 2328 implement holder that maps edge->real class
public interface EdgeType {
    Class<?> edge();
    Class<?> real();
}
