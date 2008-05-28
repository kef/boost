package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.sniper.automock.MockExpectations;

public class DefaultExpectations implements Expectations {
    private final MockExpectations mocks;
    private final NuImplExpectations nus;
    private final NuExpectations nu;

    public DefaultExpectations(MockExpectations mocks, NuImplExpectations nus, NuExpectations nu) {
        this.mocks = mocks;
        this.nus = nus;
        this.nu = nu;
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

    public <T> void nuImpl(T obj, Class<? extends T> impl, Object... params) {
        nus.nuImpl(obj, impl, params);
    }

    public <T> void nu(T obj, Class<? extends T> iface, Object... params) {
        nu.nu(obj, iface, params);
    }
}
