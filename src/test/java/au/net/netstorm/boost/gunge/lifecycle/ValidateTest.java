package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.core.Test;
import au.net.netstorm.boost.gunge.validate.TestClassValidator;

public final class ValidateTest implements TestLifecycleBlock {
    TestClassValidator validator;
    Test test;

    public void execute() {
        validator.validate(test);
    }
}
