package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;

public final class DefaultNewerDemoTest extends ResolverDemooooTest {
    public void testResolveNewer() {
        NewHeadJob newHeadJob = (NewHeadJob) resolver.resolve(NewHeadJob.class);
        assertNotNull(newHeadJob);
        Job job = newHeadJob.nu();
        job.sayHi();
    }

    public void testRecursiveNewerInjection() {
        registry.multiple(Rob.class, DefaultRob.class);
        Rob rob = (Rob) resolver.resolve(Rob.class);
        Bob bob = rob.getBob();
        checkNewersRecurse(bob);
    }

    private void checkNewersRecurse(Bob bob) {
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}

