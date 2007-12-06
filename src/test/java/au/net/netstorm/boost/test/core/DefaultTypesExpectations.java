package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public class DefaultTypesExpectations implements TypesExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultTypesExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    public <T> void types(T obj, Class<? extends T> impl, Object... params) {
        Object types = fielder.getInstance(test, "typesMock");
        expect.oneCall(types, obj, "nu", impl, params);
    }
}
