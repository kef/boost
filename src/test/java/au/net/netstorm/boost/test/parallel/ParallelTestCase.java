package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

// FIX 2000 Use or Lose.
public class ParallelTestCase extends LifecycleTestCase {
    public TestLifecycle testLifecycle() {
        return new ParallelTestLifecycle(this);
    }
}
