package au.net.netstorm.boost.edge.guts;

public interface ClassWarper {
    Class<?> edgeToReal(Class<?> edge, boolean staticy);
}
