package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertEquals;

public final class DefaultInjectionSiteChecker implements InjectionSiteChecker {
    public void checkSite(InjectionSite subject, Class<?> host, InjectionType type, String name) {
        assertSame(host, subject.host());
        assertSame(type, subject.type());
        assertEquals(name, subject.name());
    }
}
