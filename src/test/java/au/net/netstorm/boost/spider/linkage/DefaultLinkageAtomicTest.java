package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageAtomicTest extends LifecycleTestCase implements LazyFields {
    Implementation hostDummy;
    Interface ifaceDummy;
    String nameDummy;
    Interface ifaceMock;
    Integer hash;

    public void testSuccess() {
        check(hostDummy, ifaceDummy, nameDummy);
        check(null, ifaceDummy, nameDummy);
        check(hostDummy, ifaceDummy, null);
        check(null, ifaceDummy, null);
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

    private void check(Implementation host, Interface iface, String name) {
        Linkage linkage = new DefaultLinkage(host, iface, name);
        check(host, linkage);
        check(iface, linkage);
        check(name, linkage);
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

    private void check(String name, Linkage linkage) {
        checkNamed(name, linkage);
        if (name == null)
            checkGetNameBoom(linkage);
        else
            checkGetNameOk(name, linkage);
    }

    private void checkHosted(Implementation host, Linkage linkage) {
        boolean expected = host != null;
        boolean actual = linkage.hosted();
        assertEquals(expected, actual);
    }

    private void checkNamed(String name, Linkage linkage) {
        boolean expected = name != null;
        boolean actual = linkage.named();
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

    private void checkGetNameOk(String name, Linkage linkage) {
        String actual = linkage.getName();
        assertEquals(name, actual);
    }

    private void checkGetHostBoom(Linkage linkage) {
        try {
            linkage.getHost();
            fail();
        } catch (IllegalStateException e) {
            checkException(e, "host");
        }
    }

    private void checkGetNameBoom(Linkage linkage) {
        try {
            linkage.getName();
            fail();
        } catch (IllegalStateException e) {
            checkException(e, "name");
        }
    }

    private void checkException(IllegalStateException e, String field) {
        String actual = e.getMessage();
        assertEquals("No " + field + " specified", actual);
    }
}
