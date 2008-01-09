package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprintsAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_PARAMS = {};
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface iface = iface(Dinosaur.class);
    Interface dodgy = iface(Tree.class);
    Blueprint blueprint;
    NiceMap mapMock;
    Boolean exists;
    Implementation impl;
    TypeMaster typerMock;
    Blueprints subject;
    Implementation hostDummy;

    public void setUpFixtures() {
        subject = new DefaultBlueprints();
        fielder.setInstance(subject, "map", mapMock);
        blueprint = blueprint(Tyrannosaurus.class);
    }

    public void testExists() {
        expect.oneCall(mapMock, exists, "exists", iface);
        boolean actual = subject.exists(iface);
        assertEquals(exists, actual);
    }

    public void testGet() {
        expect.oneCall(mapMock, blueprint, "get", iface);
        Blueprint actual = subject.get(hostDummy, iface);
        assertEquals(blueprint, actual);
    }

    public void testPut() {
        expect.oneCall(mapMock, VOID, "put", iface, blueprint);
        subject.put(hostDummy, iface, blueprint);
    }

    public void testIllegalPut() {
        try {
            subject.put(hostDummy, dodgy, blueprint);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private Blueprint blueprint(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, NO_PARAMS);
    }
}
