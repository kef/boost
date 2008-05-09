package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.gunge.type.Data;

// FIX 2328 implement holder that maps edge->real class
public interface EdgeType extends Data {
    Class<?> getEdge();
    Class<?> getReal();
}
