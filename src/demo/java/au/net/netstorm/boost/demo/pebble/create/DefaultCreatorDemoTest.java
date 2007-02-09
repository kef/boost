package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.Creator;
import junit.framework.TestCase;

public final class DefaultCreatorDemoTest extends TestCase {
    private final CreatorAssembler creatorAssembler = new DefaultCreatorAssembler();
    private Creator creator = creatorAssembler.assembleCreator();

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
