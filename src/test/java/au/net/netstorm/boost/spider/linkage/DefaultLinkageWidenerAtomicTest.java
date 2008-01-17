package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageWidenerAtomicTest extends BoooostCase {
    LinkageWidener subject = new DefaultLinkageWidener();
    LinkageFactory linkageFactory = new DefaultLinkageFactory();
    Interface iface = new DefaultInterface(Monkey.class);
    Implementation host = new DefaultImplementation(Zoo.class);
    String name = "someName";
    Linkage linkageIface = linkageFactory.nu(iface);
    Linkage linkageHostIface = linkageFactory.nu(host, iface);
    Linkage linkageIfaceName = linkageFactory.nu(null, iface, name);
    Linkage linkageAll = linkageFactory.nu(host, iface, name);
    Linkage[] expectedIface = {linkageIface};
    Linkage[] expectedHostIface = {linkageHostIface, linkageIface};
    Linkage[] expectedIfaceName = {linkageIfaceName, linkageIface};
    Linkage[] expectedAll = {linkageAll, linkageHostIface, linkageIfaceName, linkageIface};

    public void testIface() {
        check(expectedIface, linkageIface);
    }

    public void testHostIface() {
        check(expectedHostIface, linkageHostIface);
    }

    public void testIfaceName() {
        check(expectedIfaceName, linkageIfaceName);
    }

    public void testEverything() {
        check(expectedAll, linkageAll);
    }

    private void check(Linkage[] expected, Linkage linkage) {
        Linkage[] actual = subject.widen(linkage);
        assertEquals(expected, actual);
    }
}
