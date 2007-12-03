package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;

public final class DefaultNewerDemoTest extends ResolverDemooooTest {
    public void testResolveNewer() {
        NewTopJob newTopJob = resolver.resolve(NewTopJob.class);
        assertNotNull(newTopJob);
        Job job = newTopJob.nu();
        job.sayHi();
    }

    public void testRecursiveNewerInjection() {
        registry.multiple(Rob.class, DefaultRob.class);
        Rob rob = resolver.resolve(Rob.class);
        Bob bob = rob.getBob();
        checkNewersRecurse(bob);
    }

    private void checkNewersRecurse(Bob bob) {
        NewTopJob newJobNewer = bob.getNewTopJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}

