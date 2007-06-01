package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = assembler.assemble();

    public void testResolveNewer() {
        NewHeadJob newHeadJob = (NewHeadJob) spider.resolve(NewHeadJob.class);
        assertNotNull(newHeadJob);
        Job job = newHeadJob.nu();
        job.sayHi();
    }

    public void testRecursiveNewerInjection() {
        spider.multiple(Rob.class, DefaultRob.class);
        Rob rob = (Rob) spider.resolve(Rob.class);
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

