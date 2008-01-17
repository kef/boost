package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageWidenerAtomicTest extends BoooostCase {
    private LinkageFactory linkageFactory = new DefaultLinkageFactory();
    LinkageWidener subject = new DefaultLinkageWidener();
    Interface iface = new DefaultInterface(Monkey.class);

    public void test() {
        Linkage linkage = linkageFactory.nu(iface);
        Linkage[] linkages = subject.widen(linkage);
        assertEquals(1, linkages.length);
        assertEquals(linkage, linkages[0]);
    }
}
