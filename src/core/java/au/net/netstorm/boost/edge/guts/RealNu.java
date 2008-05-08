package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;

public interface RealNu {
    <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs);
}
