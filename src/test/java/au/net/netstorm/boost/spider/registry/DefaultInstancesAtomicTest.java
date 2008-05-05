package au.net.netstorm.boost.spider.registry;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.gunge.type.DefaultBaseReference;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.flavour.StrictMap;

public final class DefaultInstancesAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    ClassTestChecker checker = new DefaultClassTestChecker();
    Interface iface;
    Implementation impl = impl(Tyrannosaurus.class);
    Dinosaur tyrannosaurus = new Tyrannosaurus();
    Tree jacaranda = new Jacaranda();
    ResolvedInstance dinosaur = ref(tyrannosaurus);
    ResolvedInstance tree = ref(jacaranda);
    StrictMap mapMock;
    Boolean exists;
    Instances subject;
    List key;

    public void setUpFixtures() {
        subject = new DefaultInstances();
        fielder.setInstance(subject, "map", mapMock);
        key = key();
    }

    public void testSynchronized() {
        checker.checkSynchronized(DefaultInstances.class);
    }

    public void testGet() {
        expect.oneCall(mapMock, dinosaur, "get", key);
        ResolvedInstance actual = subject.get(iface, impl);
        assertEquals(dinosaur, actual);
    }

    public void testExistence() {
        expect.oneCall(mapMock, exists, "exists", key);
        boolean actual = subject.exists(iface, impl);
        assertEquals(exists, actual);
    }

    public void testIllegalPut() {
        try {
            subject.put(iface, impl, tree);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testPut() {
        expect.oneCall(mapMock, VOID, "put", key, dinosaur);
        subject.put(iface, impl, dinosaur);
    }

    private List key() {
        List key = new ArrayList();
        key.add(iface);
        key.add(impl);
        return key;
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private ResolvedInstance ref(Object o) {
        return new DefaultBaseReference(o);
    }
}
