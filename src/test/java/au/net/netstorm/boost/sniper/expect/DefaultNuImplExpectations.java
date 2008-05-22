package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public class DefaultNuImplExpectations implements NuImplExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultNuImplExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    // SUGGEST (Dec 6, 2007): Could we remove the nuMock fields from our test?
    public <T> void nu(T obj, Class<? extends T> impl, Object... params) {
        Object nu = fielder.getInstance(test, "nuImplMock");
        expect.oneCall(nu, obj, "nu", impl, params);
    }
}
