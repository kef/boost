package au.net.netstorm.boost.retire.reflect;

import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;

public final class DefaultMethodEmptyStringParameterTestChecker implements MethodEmptyStringParameterTestChecker {
    private final NullMaster nullMaster = new DefaultNullMaster();
    private final ParameterCheckerTestUtil parameterUtil;

    public DefaultMethodEmptyStringParameterTestChecker(InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider);
        parameterUtil = new DefaultParameterCheckerTestUtil(instanceProvider);
    }

    public void checkPublicMethodsRejectEmptyString(Object instance) {
        nullMaster.check(instance);
        parameterUtil.checkMethodsRejectEmptyString(instance);
    }
}
