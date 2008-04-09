package au.net.netstorm.boost.spider.linkage;

import java.lang.reflect.Field;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLinkageFactoryAtomicTest extends LifecycleTestCase implements LazyFields, InjectableTest {
    private static final String FIELD_NAME = "monkey";
    Interface iface = new DefaultInterface(Monkey.class);
    Implementation host = new DefaultImplementation(Zoo.class);
    LinkageFactory subject;
    FieldTestUtil fielder;
    String name;

    public void testNuField() {
        Linkage expected = new DefaultLinkage(host, iface, FIELD_NAME);
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

    public void testNuHostIfaceName() {
        Linkage expected = new DefaultLinkage(host, iface, name);
        checkNuHostIfaceName(expected);
        checkNuHostIfaceNameStrong(expected);
    }

    public void testNuIfaceName() {
        Linkage expected = new DefaultLinkage(null, iface, name);
        checkNuIfaceName(expected);
        checkNuIfaceNameStrong(expected);
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
        Linkage actual = subject.nu(Zoo.class, Monkey.class, name);
        assertEquals(expected, actual);
    }

    private void checkNuHostIfaceNameStrong(Linkage expected) {
        Linkage actual = subject.nu(host, iface, name);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceName(Linkage expected) {
        Linkage actual = subject.nu(null, Monkey.class, name);
        assertEquals(expected, actual);
    }

    private void checkNuIfaceNameStrong(Linkage expected) {
        Linkage actual = subject.nu(null, iface, name);
        assertEquals(expected, actual);
    }
}
