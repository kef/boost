package au.net.netstorm.boost.test.fixture;

public interface TriangulationProvider {
    Object getInstance(Class type);
    boolean canProvide(Class type);
}
