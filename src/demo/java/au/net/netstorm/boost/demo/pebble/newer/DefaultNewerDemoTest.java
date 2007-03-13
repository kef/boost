package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.newer.core.ObjectProvider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private final NewerAssembler newerAssembler = new DefaultNewerAssembler();
    private ObjectProvider objectProvider = newerAssembler.assembleCreator();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        NewHeadJob newJobCreator = bob.getNewHeadJob();
        assertNotNull("newJobCreator should have been created as a dependency", newJobCreator);
    }

    private Rob createRob() {
        Object[] parameters = {};
        return (Rob) objectProvider.provide(Rob.class, parameters);
    }
}
