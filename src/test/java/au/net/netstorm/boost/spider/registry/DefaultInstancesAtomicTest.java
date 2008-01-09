package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.NiceMap;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultInstancesAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    ClassTestChecker checker = new DefaultClassTestChecker();
    Implementation impl = impl(Tyrannosaurus.class);
    Dinosaur tyrannosaurus = new Tyrannosaurus();
    Tree jacaranda = new Jacaranda();
    ResolvedInstance dinosaur = ref(tyrannosaurus);
    ResolvedInstance tree = ref(jacaranda);
    NiceMap mapMock;
    Boolean exists;
    Instances subject;

    public void setUpFixtures() {
        subject = new DefaultInstances();
        fielder.setInstance(subject, "map", mapMock);
    }

    public void testSynchronized() {
        checker.checkSynchronized(DefaultInstances.class);
    }

    public void testGet() {
        expect.oneCall(mapMock, dinosaur, "get", impl);
        ResolvedInstance actual = subject.get(impl);
        assertEquals(dinosaur, actual);
    }

    public void testExistence() {
        expect.oneCall(mapMock, exists, "exists", impl);
        boolean actual = subject.exists(impl);
        assertEquals(exists, actual);
    }

    public void testIllegalPut() {
        try {
            subject.put(impl, tree);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testPut() {
        expect.oneCall(mapMock, VOID, "put", impl, dinosaur);
        subject.put(impl, dinosaur);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private ResolvedInstance ref(Object o) {
        return new DefaultBaseReference(o);
    }
}
