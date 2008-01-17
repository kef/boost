package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageWidener;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageWidener;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageWidenerAtomicTest extends BoooostCase {
    private LinkageFactory linkageFactory = new DefaultLinkageFactory();
    LinkageWidener subject = new DefaultLinkageWidener();
    Interface iface = new DefaultInterface(Monkey.class);
    Implementation host = new DefaultImplementation(Zoo.class);
    private String name = "aName";

    public void testIface() {
        Linkage linkage = linkageFactory.nu(iface);
        Linkage[] linkages = subject.widen(linkage);
        assertEquals(1, linkages.length);
        assertEquals(linkage, linkages[0]);
    }

    public void testHostIface() {
        Linkage linkage = linkageFactory.nu(host, iface);
        Linkage[] linkages = subject.widen(linkage);
        assertEquals(2, linkages.length);
        assertEquals(linkage, linkages[0]);
        // FIX ()  93260 complete.
    }

    public void testIfaceName() {
        Linkage linkage = linkageFactory.nu(null, iface, name);
        Linkage[] linkages = subject.widen(linkage);
        assertEquals(2, linkages.length);
        assertEquals(linkage, linkages[0]);
        // FIX ()  93260 complete.
    }

    public void testEverything() {
        Linkage linkage = linkageFactory.nu(host, iface, name);
        Linkage[] linkages = subject.widen(linkage);
        assertEquals(4, linkages.length);
        assertEquals(linkage, linkages[0]);
        // FIX ()  93260 complete.
    }
}
