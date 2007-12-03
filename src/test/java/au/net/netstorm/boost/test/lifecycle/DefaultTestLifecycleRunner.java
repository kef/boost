package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.test.exception.ThrowableSupport;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    Nu nu;

    public void run(LifecycleTest test) throws Throwable {
        TestLifecycleBlocks lifecycle = test.lifecycle();
        TestLifecycleBlockRunner blockRunner = nu.nu(DefaultTestLifecycleBlockRunner.class, lifecycle);
        try {
            runTest(test, blockRunner);
        } catch (Throwable t) {
            ThrowableSupport throwableSupport = test.throwableSupport();
            throw throwableSupport.translate(t);
        } finally {
            tryCleanup(blockRunner);
        }
    }

    public void runTest(LifecycleTest test, TestLifecycleBlockRunner blockRunner) throws Throwable {
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
