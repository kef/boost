package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final SpiderAssembler assembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = assembler.assemble();

    public void testResolveNewer() {
        NewHeadJob newHeadJob = (NewHeadJob) spider.resolve(NewHeadJob.class);
        assertNotNull(newHeadJob);
        Job job = newHeadJob.nu();
        job.sayHi();
    }

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) spider.provide(Rob.class, NO_PARAMETERS);
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

