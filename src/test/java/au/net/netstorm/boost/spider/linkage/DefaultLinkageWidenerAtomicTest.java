package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX ()  93260 Refactor!
public final class DefaultLinkageWidenerAtomicTest extends BoooostCase {
    LinkageWidener subject = new DefaultLinkageWidener();
    LinkageFactory linkageFactory = new DefaultLinkageFactory();
    Interface iface = new DefaultInterface(Monkey.class);
    Implementation host = new DefaultImplementation(Zoo.class);
    String name = "aName";
    Linkage linkageIface = linkageFactory.nu(iface);
    Linkage linkageHostIface = linkageFactory.nu(host, iface);
    Linkage linkageIfaceName = linkageFactory.nu(null, iface, name);
    Linkage linkageAll = linkageFactory.nu(host, iface, name);

    public void testIface() {
        Linkage[] linkages = subject.widen(linkageIface);
        assertEquals(1, linkages.length);
        assertEquals(linkageIface, linkages[0]);
    }

    public void testHostIface() {
        Linkage[] linkages = subject.widen(linkageHostIface);
        assertEquals(2, linkages.length);
        assertEquals(linkageHostIface, linkages[0]);
        assertEquals(linkageIface, linkages[1]);
    }

    public void testIfaceName() {
        Linkage[] linkages = subject.widen(linkageIfaceName);
        assertEquals(2, linkages.length);
        assertEquals(linkageIfaceName, linkages[0]);
        assertEquals(linkageIface, linkages[1]);
    }

    public void testEverything() {
        Linkage[] linkages = subject.widen(linkageAll);
        assertEquals(4, linkages.length);
        assertEquals(linkageAll, linkages[0]);
        assertEquals(linkageHostIface, linkages[1]);
        assertEquals(linkageIfaceName, linkages[2]);
        assertEquals(linkageIface, linkages[3]);
    }
}
