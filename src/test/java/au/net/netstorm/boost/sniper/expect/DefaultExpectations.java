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

    // FIX 2394 why am i forced declare nuMock in the test when I don't acutally use, suggest it happens by automagic
    public <T> void nuImpl(T obj, Class<? extends T> impl, Object... params) {
        nus.nuImpl(obj, impl, params);
    }

    // FIX 2394 why am i forced declare typesMock in the test when I don't acutally use, suggest it happens by automagic
    public <T> void types(T obj, Class<? extends T> iface, Object... params) {
        nu.types(obj, iface, params);
    }
}
