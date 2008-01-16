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
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX 2237 Complete.
public final class DefaultBlueprintsAtomicTest extends LifecycleTestCase implements HasFixtures {
    private static final Object[] NO_PARAMS = {};
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface iface = iface(Dinosaur.class);
    Interface dodgy = iface(Tree.class);
    LinkageFactory linkageFactory = new DefaultLinkageFactory();
    Blueprint blueprint;
    Boolean exists;
    Implementation impl;
    TypeMaster typerMock;
    Blueprints subject;
    Implementation hostDummy;

    public void setUpFixtures() {
        subject = new DefaultBlueprints();
        blueprint = blueprint(Tyrannosaurus.class);
    }

    // FIX 2237 Reinstate.
/*
    public void testExists() {
        expect.oneCall(mapMock, exists, "exists", iface);
        boolean actual = subject.exists(iface);
        assertEquals(exists, actual);
    }
*/

    // FIX 2237 Reinstate.
/*
    public void testGet() {
        expect.oneCall(mapMock, blueprint, "get", iface);
        Blueprint actual = subject.get(hostDummy, iface);
        assertEquals(blueprint, actual);
    }
*/

    public void testPut() {
        Linkage linkage = linkageFactory.nu(iface);
        subject.put(linkage, blueprint);
    }

    public void testIllegalPut() {
        Linkage linkage = linkageFactory.nu(dodgy);
        try {
            subject.put(linkage, blueprint);
            fail();
        } catch (WrongRegistrationException expected) { }
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private Blueprint blueprint(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, NO_PARAMS);
    }
}
