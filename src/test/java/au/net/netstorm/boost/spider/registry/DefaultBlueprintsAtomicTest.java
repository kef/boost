package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.nursery.spider.registry.WrongRegistrationException;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX 2237 Complete.
public final class DefaultBlueprintsAtomicTest extends LifecycleTestCase implements HasFixtures {
    private static final Object[] NO_PARAMS = {};
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface dinosaurIface = iface(Dinosaur.class);
    Interface iface2 = iface(Fish.class);
    Interface dodgy = iface(Tree.class);
    Implementation host = new DefaultImplementation(Museum.class);
    LinkageFactory linkageFactory = new DefaultLinkageFactory();
    Blueprint blueprint;
    Blueprint anotherBlueprint;
    Blueprints subject;
    Implementation hostDummy;
    Linkage ifaceLink = linkageFactory.nu(dinosaurIface);
    Linkage hostLink = linkageFactory.nu(host, dinosaurIface);
    Linkage[] linkages = {
//            linkageFactory.nu(host, iface1, "aName"),
//            linkageFactory.nu(host, dinosaurIface),
            // FIX () 2237 check that null host is actually used...
//            linkageFactory.nu(null, iface1, "aName"),
            ifaceLink,
    };

    public void setUpFixtures() {
        subject = new DefaultBlueprints();
        blueprint = blueprint(Tyrannosaurus.class);
        anotherBlueprint = blueprint(Triceratops.class);
    }

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

    // FIX 2237 Complete.  Exists must work for all widenings of the linkage.
    // FIX   2237 In fact, this loop concept is broken.
    public void testExists() {
        for (Linkage linkage : linkages) {
            checkExists(false, linkage);
            checkExists(true, linkage);
        }
    }

    private void checkExists(boolean exists, Linkage linkage) {
        if (exists) subject.put(linkage, blueprint);
        boolean actual = subject.exists(linkage);
        assertEquals(exists, actual);
    }

    // FIX   2237 Complete.  Do more types of linkages.
    public void testGet() {
        subject.put(ifaceLink, blueprint);
        check(ifaceLink, blueprint);
        check(hostLink, blueprint);
        subject.put(hostLink, anotherBlueprint);
        check(hostLink, anotherBlueprint);
    }

    private void check(Linkage linkage, Blueprint blueprint) {
        Blueprint actual = subject.get(linkage);
        assertEquals(blueprint, actual);
    }

    public void testGetPops() {
        try {
            subject.get(ifaceLink);
        } catch (IllegalStateException expected) {
        }
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private Blueprint blueprint(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, NO_PARAMS);
    }
}
