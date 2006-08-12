package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.util.exception.NotImplementedException;

public final class TestTriangulationProvider implements TriangulationProvider {
    public Object getInstance(Class type) {
        Object ref = doGetInstance(type);
        if (ref != null) return ref;
        throw new UnsupportedOperationException("Hmm.  Provide an instance of " + type + ".  Might be worth edgifying this type or talking to the boosters");
    }

    public boolean canProvide(Class type) {
        Object ref = doGetInstance(type);
        return ref != null;
    }

    private Object doGetInstance(Class type) {
        throw new NotImplementedException();
    }
}
