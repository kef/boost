package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.automock.MockExpectations;

public class DefaultExpectations implements Expectations {
    private final MockExpectations mocks;
    private final NuExpectations nus;

    public DefaultExpectations(MockExpectations mocks, NuExpectations nus) {
        this.mocks = mocks;
        this.nus = nus;
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

    public <T> void nu(T obj, Class<T> impl, Object... params) {
        nus.nu(obj, impl, params, params);
    }
}
