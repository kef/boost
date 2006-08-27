package au.net.netstorm.boost.nursery.start;

import junit.framework.TestCase;

public class DefaultBootstrapAtomicTest extends TestCase {
    public void testAction() {
        Bootstrapper bootstrapper = new DefaultBootstrapper();
        try {
            bootstrapper.bootstrap(VmStyleAtomicTest.VM_STYLE_PINK_FLOYD);
        } catch (UnsupportedOperationException expected) {
        }
    }
}
