package au.net.netstorm.boost.spider.linkage;

import java.lang.reflect.Field;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultLinkageFactoryAtomicTest extends LifecycleTestCase implements LazyFields, InjectableTest {
    private static final String FIELD_NAME = "monkey";
    Interface iface = new DefaultInterface(Monkey.class);
    Implementation host = new DefaultImplementation(Zoo.class);
    Anchor anchor = new DefaultAnchor(FIELD_NAME);
    LinkageFactory subject;
    FieldTestUtil fielder;

    public void testNuField() {
        Linkage expected = new DefaultLinkage(host, iface, anchor);
        Field field = fielder.get(Zoo.class, FIELD_NAME);
        Linkage actual = subject.nu(field);
        assertEquals(expected, actual);
    }

    public void testNuIface() {
        Linkage expected = new DefaultLinkage(null, iface, null);
        checkNuIface(expected);
        checkNuIfaceStrong(expected);
    }

    public void testNuHostIface() {
        Linkage expected = new DefaultLinkage(host, iface, null);
        checkNuHostIface(expected);
        checkNuHostIfaceStrong(expected);
    }

    public void testNuHostIfaceAnchor() {
        Linkage expected = new DefaultLinkage(host, iface, anchor);
        checkNuHostIfaceName(expected);
        checkNuHostIfaceNameStrong(expected);
        checkNuHostIfaceAnchorStrong(expected);
    }

    public void testNuIfaceAnchor() {
        Linkage expected = new DefaultLinkage(null, iface, anchor);
        checkNuIfaceName(expected);
        checkNuIfaceNameStrong(expected);
        checkNuIfaceAnchorStrong(expected);
    }

    private void checkNuIface(Linkage expected) {
        Linkage actual = subject.nu(Monkey.class);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceStrong(Linkage expected) {
        Linkage actual = subject.nu(iface);
        assertEquals(expected, actual);
    }

    private void checkNuHostIface(Linkage expected) {
        Linkage actual = subject.nu(Zoo.class, Monkey.class);
        assertEquals(expected, actual);
    }

    private void checkNuHostIfaceStrong(Linkage expected) {
        Linkage actual = subject.nu(host, iface);
        assertEquals(expected, actual);
    }

    private void checkNuHostIfaceName(Linkage expected) {
        Linkage actual = subject.nu(Zoo.class, Monkey.class, FIELD_NAME);
        assertEquals(expected, actual);
    }

    private void checkNuHostIfaceAnchorStrong(Linkage expected) {
        Linkage actual = subject.nu(host, iface, anchor);
        assertEquals(expected, actual);
    }

    private void checkNuHostIfaceNameStrong(Linkage expected) {
        Linkage actual = subject.nu(host, iface, FIELD_NAME);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceName(Linkage expected) {
        Linkage actual = subject.nu(null, Monkey.class, FIELD_NAME);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceNameStrong(Linkage expected) {
        Linkage actual = subject.nu(null, iface, FIELD_NAME);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceAnchorStrong(Linkage expected) {
        Linkage actual = subject.nu(null, iface, anchor);
        assertEquals(expected, actual);
    }
}
