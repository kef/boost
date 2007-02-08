package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.demo.pebble.fixtures.Bob;
import au.net.netstorm.boost.demo.pebble.fixtures.JobNewer;
import au.net.netstorm.boost.demo.pebble.fixtures.Rob;
import au.net.netstorm.boost.nursery.pebble.create.DefaultOldCreator;
import au.net.netstorm.boost.nursery.pebble.create.OldCreator;
import junit.framework.TestCase;

// FIX 1665 Stitch in new CreatorField.
public final class DefaultCreatorDemoTest extends TestCase {
    private OldCreator creator = new DefaultOldCreator();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        JobNewer newJobCreator = bob.getNewJobCreator();
        assertNotNull("newJobCreator should have been created as a dependency", newJobCreator);
    }

    private Rob createRob() {
        Object[] parameters = {};
        return (Rob) creator.create(Rob.class, parameters);
    }
}
