package au.net.netstorm.boost.retire.reflect;

import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;

public final class DefaultConstructorEmptyStringChecker implements ConstructorEmptyStringChecker {
    private final NullMaster nullMaster = new DefaultNullMaster();
    private final ParameterCheckerTestUtil parameterUtil;

    public DefaultConstructorEmptyStringChecker(final InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider);
        parameterUtil = new DefaultParameterCheckerTestUtil(instanceProvider);
    }

    public void checkPublicConstructorsRejectEmptyString(Class classToCheck) {
        nullMaster.check(classToCheck);
        parameterUtil.checkConstructorsRejectEmptyString(classToCheck);
    }
}
