package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public class DefaultTypesExpectations implements TypesExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultTypesExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    // FIX BREADCRUMB 2394 rename me
    public <T> void types(T obj, Class<? extends T> iface, Object... params) {
        Object types = fielder.getInstance(test, "nuMock");
        expect.oneCall(types, obj, "nu", iface, params);
    }
}
