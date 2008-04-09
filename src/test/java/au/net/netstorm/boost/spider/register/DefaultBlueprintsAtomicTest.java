package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultBlueprintsAtomicTest extends LifecycleTestCase {
    private static final Object[] NO_PARAMS = {};
    Interface dinosaurIface = iface(Dinosaur.class);
    Interface dodgy = iface(Tree.class);
    Implementation host = new DefaultImplementation(Museum.class);
    LinkageFactory linkageFactory = new DefaultLinkageFactory();
    Blueprint blueprint = blueprint(Tyrannosaurus.class);
    Blueprint anotherBlueprint = blueprint(Triceratops.class);
    Blueprints subject = new DefaultBlueprints();
    Linkage ifaceLink = linkageFactory.nu(dinosaurIface);
    Linkage hostLink = linkageFactory.nu(host, dinosaurIface);

    public void testPut() {
        Linkage linkage = linkageFactory.nu(dinosaurIface);
        subject.put(linkage, blueprint);
    }

    public void testIllegalPut() {
        Linkage linkage = linkageFactory.nu(dodgy);
        try {
            subject.put(linkage, blueprint);
            fail();
        } catch (WrongRegistrationException expected) { }
    }

    public void testExists() {
        checkExists(false, ifaceLink);
        subject.put(ifaceLink, blueprint);
        checkExists(true, ifaceLink);
        checkExists(true, hostLink);
    }

    public void testGet() {
        subject.put(ifaceLink, blueprint);
        checkGet(ifaceLink, blueprint);
        checkGet(hostLink, blueprint);
        subject.put(hostLink, anotherBlueprint);
        checkGet(hostLink, anotherBlueprint);
    }

    public void testGetPops() {
        try {
            subject.get(ifaceLink);
        } catch (IllegalStateException expected) {
        }
    }

    private void checkExists(boolean exists, Linkage linkage) {
        boolean actual = subject.exists(linkage);
        assertEquals(exists, actual);
    }

    private void checkGet(Linkage linkage, Blueprint blueprint) {
        Blueprint actual = subject.get(linkage);
        assertEquals(blueprint, actual);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private Blueprint blueprint(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, NO_PARAMS);
    }
}
