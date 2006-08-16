package au.net.netstorm.boost.test.atom;

public interface TriangulationProvider {
    Object getInstance(Class type);

    Object[] getInstances(Class[] types);
}
