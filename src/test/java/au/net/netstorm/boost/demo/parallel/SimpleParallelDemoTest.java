package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.parallel.Parallel;

public final class SimpleParallelDemoTest extends InteractionTestCase implements Parallel, Timed {
    Integer threads = 5;

    // FIX 2000 Delete me.
    public void testDeleteMe() {
        print("found it");
    }

    public void testFoo1() {
        print("go us!");
    }

    public void testPoo() {
        print("poo poo");
    }

    private void print(String msg) {
        // Print something out to see this in action.
    }
}
