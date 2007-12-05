package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public class DefaultNuExpectations implements NuExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultNuExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    public <T> void nu(T obj, Class<? extends T> impl, Object... params) {
        Object nu = fielder.getInstance(test, "nuMock");
        expect.oneCall(nu, obj, "nu", impl, params);
    }
}
