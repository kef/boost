package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

// FIX 2000 Use or Lose.
public class ParallelTestLifecycle implements TestLifecycle {
    private final ParallelRunner runner = new DefaultParallelRunner();
    private final ParallelTestCase test;
    private Integer threads = 0;

    public ParallelTestLifecycle(ParallelTestCase test) {
        this.test = test;
    }

    public void pre() {
    }

    public void run() throws Throwable {
        runner.run(test, threads);
    }

    public void post() {
    }

    public void cleanup(boolean successful) {
    }
}
