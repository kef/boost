package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public class ParallelTest extends InteractionTestCase {
    private final SpiderBuilder builder = new DefaultSpiderBuilder();
    private final Spider spider = builder.build();
    public final Resolver resolver = spider;
}
