package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.validate.TestClassValidator;

public final class ValidateTest implements TestLifecycleBlock {
    TestClassValidator validator;
    Test test;

    public void execute() {
        validator.validate(test);
    }
}
