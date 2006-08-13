package au.net.netstorm.boost.test.fixture;

public interface TriangulationProvider {
    Object getInstance(Class type);

    Object[] getInstances(Class[] types);
}
