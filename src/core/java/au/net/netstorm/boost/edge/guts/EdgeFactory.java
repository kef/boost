package au.net.netstorm.boost.edge.guts;

// FIX 2328 implement me
public interface EdgeFactory {
    <E> E nu(Class<E> edgeClass, Class<?> realClass, Object real);
}
