package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstancesAtomicTest extends InteractionTestCase implements HasFixtures {
    Interface iface = iface(Dinosaur.class);
    Dinosaur tyrannosaurus = new Tyrannosaurus();
    Tree jacaranda = new Jacaranda();
    ResolvedInstance dinosaur = ref(tyrannosaurus);
    ResolvedInstance tree = ref(jacaranda);
    FlavouredMap mapMock;
    Boolean exists;
    Flavour flavour;
    Instances subject;

    public void setUpFixtures() {
        subject = new DefaultInstances(mapMock);
    }

    public void testGet() {
        expect.oneCall(mapMock, dinosaur, "get", iface, flavour);
        ResolvedInstance actual = subject.get(iface, flavour);
        assertEquals(dinosaur, actual);
    }

    public void testExists() {
        expect.oneCall(mapMock, exists, "exists", iface, flavour);
        boolean actual = subject.exists(iface, flavour);
        assertEquals(exists, actual);
    }

    public void testIllegalPut() {
        try {
            subject.put(iface, flavour, tree);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testPut() {
        expect.oneCall(mapMock, VOID, "put", iface, flavour, dinosaur);
        subject.put(iface, flavour, dinosaur);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private ResolvedInstance ref(Object o) {
        return new DefaultBaseReference(o);
    }
}
