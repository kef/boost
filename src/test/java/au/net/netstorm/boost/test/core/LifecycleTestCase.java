package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.exception.DefaultExceptionSupport;
import au.net.netstorm.boost.test.exception.ExceptionSupport;
import au.net.netstorm.boost.test.exception.ExceptionSupportProvider;
import au.net.netstorm.boost.test.lifecycle.DefaultLifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.LifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleProvider;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.specific.DefaultTargetted;
import au.net.netstorm.boost.test.specific.ImplementationSpecificProvider;
import au.net.netstorm.boost.test.specific.InterfaceSpecificProvider;
import au.net.netstorm.boost.test.specific.Targetted;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public abstract class LifecycleTestCase extends CleanTestCase implements TestLifecycleProvider, ExceptionSupportProvider {
    // FIX 2076 Try not to make this available to subclasses
    // FIX 2076 Sort out why the name does not match the interface.
    public final Targetted specifics = new DefaultTargetted();
    // FIX 2076 Which of these should be available to sub-classes.
    public final Provider random; // FIX 2076 Getter for this?
    public MockExpectations expect;
    private final LifecycleTestRunner runner;

    public LifecycleTestCase() {
        RandomProviderAssembler assembler = new DefaultRandomProviderAssembler();
        random = assembler.everything(specifics);
        runner = new DefaultLifecycleTestRunner(this);
        // FIX 2076 Remove from here.  TestLifecycles should delegate out to get this.
        initSpecifics();
    }

    public final void runBare() throws Throwable {
        runner.run();
    }

    public ExceptionSupport exceptionSupport() {
        return new DefaultExceptionSupport();
    }

    // FIX 2076 Delegate.
    private void initSpecifics() {
        specifics.add(Interface.class, new InterfaceSpecificProvider());
        specifics.add(Implementation.class, new ImplementationSpecificProvider());
    }
}
