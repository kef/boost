package au.net.netstorm.boost.nursery.start;

import au.net.netstorm.boost.test.cases.BoooostCase;

public class DefaultBootstrapAtomicTest extends BoooostCase {
    public void testAction() {
        Bootstrapper bootstrapper = new DefaultBootstrapper();
        try {
            bootstrapper.bootstrap(VmStyleAtomicTest.VM_STYLE_PINK_FLOYD);
        } catch (UnsupportedOperationException expected) {
        }
    }
}
