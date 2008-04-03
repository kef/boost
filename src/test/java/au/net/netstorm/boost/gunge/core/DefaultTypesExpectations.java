package au.net.netstorm.boost.gunge.core;

import au.net.netstorm.boost.gunge.automock.MockExpectations;
import au.net.netstorm.boost.gunge.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.type.core.Holder;
import au.net.netstorm.boost.util.type.Data;

public class DefaultTypesExpectations implements TypesExpectations {
    private final MockExpectations expect;
    FieldTestUtil fielder;
    Test test;

    public DefaultTypesExpectations(MockExpectations expect) {
        this.expect = expect;
    }

    public <T extends Holder> void types(T obj, Class<T> iface, Object param) {
        Object types = fielder.getInstance(test, "typesMock");
        expect.oneCall(types, obj, "nu", iface, param);
    }

    public <T extends Data> void types(T obj, Class<T> iface, Object... params) {
        Object types = fielder.getInstance(test, "typesMock");
        expect.oneCall(types, obj, "nu", iface, params);
    }
}
