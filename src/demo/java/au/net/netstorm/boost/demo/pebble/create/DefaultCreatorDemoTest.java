package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.Creator;
import au.net.netstorm.boost.pebble.create.DefaultCreator;
import junit.framework.TestCase;

public final class DefaultCreatorDemoTest extends TestCase {
    private Creator creator = new DefaultCreator();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        NewHeadJob newJobCreator = bob.getNewHeadJob();
        assertNotNull("newJobCreator should have been created as a dependency", newJobCreator);
    }

    private Rob createRob() {
        Object[] parameters = {};
        return (Rob) creator.create(Rob.class, parameters);
    }
}
