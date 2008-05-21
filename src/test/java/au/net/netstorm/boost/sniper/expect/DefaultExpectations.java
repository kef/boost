package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.sniper.automock.MockExpectations;

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

    public <T> void types(T obj, Class<? extends T> iface, Object... params) {
        types.types(obj, iface, params);
    }
}
