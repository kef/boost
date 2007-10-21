package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.parallel.Parallel;

public final class SimpleParallelDemoTest extends InteractionTestCase implements Parallel, InjectableSubject, LazyFields, HasFixtures {
    RailwayTrack subject;
    Integer threads = 5;

    public void setUpFixtures() {
        subject = new DefaultRailwayTrack();
    }

    // FIX 2000 Complete me!!!!!!!!!!!!
    public void testParallelisation() {
//        Train train = subject.getTrain();
//        boolean empty = train == null;
//        assertEquals(false, empty);
    }
}
