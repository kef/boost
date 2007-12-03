package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.exception.ThrowableSupport;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    ThrowableSupport throwableSupport;
    TestLifecycleBlocks lifecycle;
    Test test;
    Nu nu;

    public void run() throws Throwable {
        TestLifecycleBlockRunner blockRunner = nu.nu(DefaultTestLifecycleBlockRunner.class, lifecycle);
        try {
            runTest(blockRunner);
        } catch (Throwable t) {
            throw throwableSupport.translate(t);
        } finally {
            tryCleanup(blockRunner);
        }
    }

    public void runTest(TestLifecycleBlockRunner blockRunner) throws Throwable {
        blockRunner.pre();
        test.runTest();
        blockRunner.post();
    }

    // OK GenericIllegalRegexp {
    public void tryCleanup(TestLifecycleBlockRunner blockRunner) {
        try {
            blockRunner.cleanup();
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've barfed during test lifecycle cleanup... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
