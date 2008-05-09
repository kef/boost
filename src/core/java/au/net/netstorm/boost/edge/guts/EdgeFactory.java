package au.net.netstorm.boost.edge.guts;

public interface EdgeFactory {
    <E> E nu(Class<E> edgeClass, Class<?> realClass, Object real);
}
