package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.nursery.type.core.Holder;
import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.util.type.Data;

public class DefaultExpectations implements Expectations {
    private final MockExpectations mocks;
    private final NuExpectations nus;
    private final TypesExpectations types;

    public DefaultExpectations(MockExpectations mocks, NuExpectations nus, TypesExpectations types) {
        this.mocks = mocks;
        this.nus = nus;
        this.types = types;
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object... parameters) {
        mocks.oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object... params) {
        mocks.oneCall(ref, throwable, methodName, params);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters) {
        mocks.manyCalls(ref, returnValue, methodName, parameters);
    }

    public <T> void nu(T obj, Class<? extends T> impl, Object... params) {
        nus.nu(obj, impl, params);
    }

    public <T extends Holder> void types(T obj, Class<T> iface, Object param) {
        types.types(obj, iface, param);
    }

    public <T extends Data> void types(T obj, Class<T> iface, Object... params) {
        types.types(obj, iface, params);
    }
}
