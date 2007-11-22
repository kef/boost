package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;

public class CyclicDependancyResolutionDemoTest extends ResolverDemooooTest {

    public void test() {
        resolver.resolve(GenericCycler.class);
    }
}
