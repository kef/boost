package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public class ParallelTest extends InteractionTestCase {
    private static final SpiderBuilder builder = new DefaultSpiderBuilder();
    private static Spider spider;

    public static synchronized Spider getSpider() {
        if (spider == null) spider = builder.build();
        return spider;
    }
}
