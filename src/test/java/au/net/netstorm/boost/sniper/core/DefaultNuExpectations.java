package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public class DefaultNuExpectations implements NuExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultNuExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    // SUGGEST (Dec 6, 2007): Could we remove the nuMock fields from our test?
    public <T> void nu(T obj, Class<? extends T> impl, Object... params) {
        Object nu = fielder.getInstance(test, "nuMock");
        expect.oneCall(nu, obj, "nu", impl, params);
    }
}
