package au.net.netstorm.boost.test.fixture;

// FIX SC600 Remove
public final class TestEmptyTriangulationProvider implements TriangulationProvider {
    public Object getInstance(Class type) {
        throw new RuntimeException("We do not provide any instances.");
    }

    public boolean canProvide(Class type) {
        return false;
    }
}
