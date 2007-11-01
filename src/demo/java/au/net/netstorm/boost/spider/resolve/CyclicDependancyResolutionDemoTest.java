package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.test.core.BoooostCase;

public class CyclicDependancyResolutionDemoTest extends BoooostCase {

    public void test() {
        Resolver resolver = getResolver();
        resolver.resolve(GenericCycler.class);
    }

    private Resolver getResolver() {
        SpiderBuilder builder = new DefaultSpiderBuilder();
        return builder.build();
    }
}
