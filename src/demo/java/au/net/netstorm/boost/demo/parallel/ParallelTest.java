package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.parallel.Parallel;

public class ParallelTest extends InteractionTestCase implements Parallel {
    private static final SpiderBuilder builder = new DefaultSpiderBuilder();
    private static final Spider spider = builder.build();
    public static final Resolver resolver = spider;
    public static final Provider provider = spider;
}
