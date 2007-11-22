package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.provider.Nu;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.parallel.Parallel;

public class ParallelTest extends InteractionTestCase implements Parallel {
    private static final BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
    private static final Spider spider = builder.build();
    public static final Resolver resolver = spider;
    public static final Nu nu = spider;
}
