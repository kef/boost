package au.net.netstorm.boost.retire.reflect;

import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;

public final class DefaultMethodNullParameterTestChecker implements MethodNullParameterTestChecker {
    private final NullMaster nullMaster = new DefaultNullMaster();
    private final ParameterCheckerTestUtil parameterUtil;

    public DefaultMethodNullParameterTestChecker(InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider);
        parameterUtil = new DefaultParameterCheckerTestUtil(instanceProvider);
    }

    public void checkPublicMethodsRejectNull(Object instance) {
        nullMaster.check(instance);
        parameterUtil.checkMethodsRejectsNull(instance);
    }
}
