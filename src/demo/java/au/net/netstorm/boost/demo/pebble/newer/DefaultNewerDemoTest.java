package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.newer.core.ObjectProvider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private final ObjectProvderAssembler objectProvderAssembler = new DefaultObjectProvderAssembler();
    private ObjectProvider objectProvider = objectProvderAssembler.assemble();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        assertNotNull("newJobNewer should have been created as a dependency", newJobNewer);
    }

    private Rob createRob() {
        Object[] parameters = {};
        return (Rob) objectProvider.provide(Rob.class, parameters);
    }
}
