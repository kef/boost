package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;

public final class DefaultMockExpectations implements MockExpectations {
    AutoMocker autoMocker;

    public DefaultMockExpectations(AutoMocker autoMocker) {
        this.autoMocker = autoMocker;
    }

    public void call(Object ref, String method, Object returnValue, Object param0) {
        // FIX SC525 Complete this.
//        mockMap.stubs().method("get").with(eq("quake")).will(returnValue(value));
        Mock mock = autoMocker.getMock(ref);
        //mockMap.stubs(me)
    }
}
