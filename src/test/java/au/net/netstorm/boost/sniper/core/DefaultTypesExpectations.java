package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.nursery.type.core.Holder;
import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

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
