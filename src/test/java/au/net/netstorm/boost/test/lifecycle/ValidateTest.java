package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.validate.TestClassValidator;

public final class ValidateTest implements TestLifecycleBlock {
    TestClassValidator validator;
    Test test;

    public void execute() {
        validator.validate(test);
    }
}
