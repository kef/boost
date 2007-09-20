package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.InterfaceMap;
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
    InterfaceMap mapMock;
    Boolean exists;
    Instances subject;

    public void setUpFixtures() {
        subject = new DefaultInstances(mapMock);
    }

    public void testGet() {
        expect.oneCall(mapMock, dinosaur, "get", iface);
        ResolvedInstance actual = subject.get(iface);
        assertEquals(dinosaur, actual);
    }

    public void testExistence() {
        expect.oneCall(mapMock, exists, "exists", iface);
        boolean actual = subject.exists(iface);
        assertEquals(exists, actual);
    }

    public void testIllegalPut() {
        try {
            subject.put(iface, tree);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testPut() {
        expect.oneCall(mapMock, VOID, "put", iface, dinosaur);
        subject.put(iface, dinosaur);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }

    private ResolvedInstance ref(Object o) {
        return new DefaultBaseReference(o);
    }
}
