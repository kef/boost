package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.demo.pebble.fixtures.Bob;
import au.net.netstorm.boost.demo.pebble.fixtures.JobCreator;
import au.net.netstorm.boost.demo.pebble.fixtures.Rob;
import au.net.netstorm.boost.nursery.pebble.create.DefaultGenericCreator;
import au.net.netstorm.boost.nursery.pebble.create.GenericCreator;
import junit.framework.TestCase;

// DEBT LineLength {
public final class DefaultCreatorDemoTest extends TestCase {
    private GenericCreator genericCreator = new DefaultGenericCreator();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        JobCreator newJobCreator = bob.getNewJobCreator();
        assertNotNull("newJobCreator should have been created as a dependency", newJobCreator);
    }

    private Rob createRob() {
        Object[] parameters = {};
        return (Rob) genericCreator.create(Rob.class, parameters);
    }
}
// } DEBT LineLength