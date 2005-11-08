package au.net.netstorm.boost.start;

import junit.framework.TestCase;

public class DefaultBootstrapAtomicTest extends TestCase {

    public void testAction() {
        DefaultBootstrapper bootstrapper = new DefaultBootstrapper();
        try {
            bootstrapper.bootstrap(VmStyleAtomicTest.VM_STYLE_PINK_FLOYD);
        } catch (UnsupportedOperationException expected) {
        }
    }

}
