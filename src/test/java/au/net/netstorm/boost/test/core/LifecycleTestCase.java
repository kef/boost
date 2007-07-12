package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.exception.DefaultExceptionSupport;
import au.net.netstorm.boost.test.exception.ExceptionSupport;
import au.net.netstorm.boost.test.exception.ExceptionSupportProvider;
import au.net.netstorm.boost.test.lifecycle.DefaultLifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.LifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleProvider;
import au.net.netstorm.boost.test.random.DefaultSpecificProviderAssembler;
import au.net.netstorm.boost.test.random.SpecificProviderAssembler;
import au.net.netstorm.boost.test.specific.DefaultSpecifics;
import au.net.netstorm.boost.test.specific.Specifics;

public abstract class LifecycleTestCase extends CleanTestCase implements TestLifecycleProvider, ExceptionSupportProvider {
    // FIX 2076 Try not to make this available to subclasses
    public final Specifics specifics = new DefaultSpecifics();
    // FIX 2076 Which of these should be available to sub-classes.
    public final Provider random;
    public MockExpectations expect;
    private final LifecycleTestRunner runner;

    public LifecycleTestCase() {
        SpecificProviderAssembler assembler = new DefaultSpecificProviderAssembler();
        random = assembler.everything(specifics);
        runner = new DefaultLifecycleTestRunner(this);
    }

    public final void runBare() throws Throwable {
        runner.run();
    }

    public Specifics getSpecifics() {
        return specifics;
    }

    public ExceptionSupport exceptionSupport() {
        return new DefaultExceptionSupport();
    }
}
