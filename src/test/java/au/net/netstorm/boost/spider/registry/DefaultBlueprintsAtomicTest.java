package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultBlueprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    Interface iface = iface(Dinosaur.class);
    Interface dodgy = iface(Tree.class);
    Blueprint blueprint;
    FlavouredMap flavouredMapMock;
    Boolean exists;
    Flavour flavour;
    Implementation impl;
    TypeMaster typerMock;
    Blueprints subject;

    public void setUpFixtures() {
        subject = new DefaultBlueprints(flavouredMapMock);
        blueprint = blueprint(Tyrannosaurus.class, flavour);
    }

    public void testExists() {
        expect.oneCall(flavouredMapMock, exists, "exists", iface, flavour);
        boolean actual = subject.exists(iface, flavour);
        assertEquals(exists, actual);
    }

    public void testGet() {
        expect.oneCall(flavouredMapMock, blueprint, "get", iface, flavour);
        Blueprint actual = subject.get(iface, flavour);
        assertEquals(blueprint, actual);
    }

    public void testPut() {
        expect.oneCall(flavouredMapMock, VOID, "put", iface, flavour, blueprint);
        subject.put(iface, flavour, blueprint);
    }

    public void testIllegalPut() {
        try {
            subject.put(dodgy, flavour, blueprint);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private Blueprint blueprint(Class cls, Flavour flavour) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, flavour);
    }
}
