package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultSpidersWebAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    Spider spiderMock;
    Web webMock;

    public void testData() {
        SpidersWeb subject = new DefaultSpidersWeb(webMock, spiderMock);
        assertSame(webMock, subject.web());
        assertSame(spiderMock, subject.spider());
    }
}
