package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultLinkageAtomicTest extends LifecycleTestCase implements LazyFields {
    String nameDummy;
    Implementation hostDummy;
    Interface ifaceDummy;
    Interface ifaceMock;
    Integer hash;

    public void testSuccess() {
        // FIX 2363 just until linkage accepts anchors
        Anchor anchorDummy = new DefaultAnchor(nameDummy);
        check(hostDummy, ifaceDummy, anchorDummy, nameDummy);
        check(null, ifaceDummy, anchorDummy, nameDummy);
        check(hostDummy, ifaceDummy, null, null);
        check(null, ifaceDummy, null, null);
    }

    public void testFail() {
        try {
            new DefaultLinkage(hostDummy, null, nameDummy);
            fail();
        } catch (IllegalStateException e) {
            String actual = e.getMessage();
            assertEquals("No nulls.", actual);
        }
    }

    public void testHashCode() {
        expect.oneCall(ifaceMock, hash, "hashCode");
        Linkage subject = new DefaultLinkage(hostDummy, ifaceMock, nameDummy);
        int actual = subject.hashCode();
        assertEquals(hash, actual);
    }

    private void check(Implementation host, Interface iface, Anchor anchor, String name) {
        Linkage linkage = new DefaultLinkage(host, iface, name);
        check(host, linkage);
        check(iface, linkage);
        check(anchor, linkage);
    }

    private void check(Interface iface, Linkage linkage) {
        checkGetIfaceOk(iface, linkage);
    }

    private void check(Implementation host, Linkage linkage) {
        checkHosted(host, linkage);
        if (host == null)
            checkGetHostBoom(linkage);
        else
            checkGetHostOk(host, linkage);
    }

    private void check(Anchor anchor, Linkage linkage) {
        checkAnchored(anchor, linkage);
        if (anchor == null)
            checkGetAnchorBoom(linkage);
        else
            checkGetAnchorOk(anchor, linkage);
    }

    private void checkHosted(Implementation host, Linkage linkage) {
        boolean expected = host != null;
        boolean actual = linkage.hosted();
        assertEquals(expected, actual);
    }

    private void checkAnchored(Anchor anchor, Linkage linkage) {
        boolean expected = anchor != null;
        boolean actual = linkage.anchored();
        assertEquals(expected, actual);
    }

    private void checkGetIfaceOk(Interface iface, Linkage linkage) {
        Interface actual = linkage.getIface();
        assertEquals(iface, actual);
    }

    private void checkGetHostOk(Implementation host, Linkage linkage) {
        Implementation actual = linkage.getHost();
        assertEquals(host, actual);
    }

    private void checkGetAnchorOk(Anchor anchor, Linkage linkage) {
        Anchor actual = linkage.getAnchor();
        assertEquals(anchor, actual);
    }

    private void checkGetHostBoom(Linkage linkage) {
        try {
            linkage.getHost();
            fail();
        } catch (IllegalStateException e) {
            checkException(e, "host");
        }
    }

    private void checkGetAnchorBoom(Linkage linkage) {
        try {
            linkage.getAnchor();
            fail();
        } catch (IllegalStateException e) {
            checkException(e, "anchor");
        }
    }

    private void checkException(IllegalStateException e, String field) {
        String actual = e.getMessage();
        assertEquals("No " + field + " specified", actual);
    }
}
