package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public class DefaultNuExpectations implements NuExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultNuExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    // FIX BREADCRUMB 2394 rename me
    public <T> void nu(T obj, Class<? extends T> iface, Object... params) {
        Object nu = fielder.getInstance(test, "nuMock");
        expect.oneCall(nu, obj, "nu", iface, params);
    }
}
