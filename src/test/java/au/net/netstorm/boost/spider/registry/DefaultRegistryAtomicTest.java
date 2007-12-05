package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultRegistryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_ARGS = new Object[0];
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    Class soapFactoryClass = SoapFactory.class;
    Class cerealClass = BreakfastCereal.class;
    Class footballClass = Football.class;
    Class sportClass = Sport.class;
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface sportInterface = new DefaultInterface(sportClass);
    Interface cerealInterface = new DefaultInterface(cerealClass);
    CocoPops cocoPops = new CocoPops();
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    Blueprints blueprintsMock;
    Instances instancesMock;
    Factories factoriesMock;
    EdgeClass classerMock;
    TypeMaster typerMock;
    Factory factoryDummy;
    Registry subject;
    Nu nuMock;

    public void setUpFixtures() {
        subject = new DefaultRegistry(blueprintsMock, instancesMock, factoriesMock, nuMock);
    }

    public void testMultiple() {
        setUpMultiple();
        subject.multiple(sportClass, footballClass);
    }

    public void testSingle() {
        setUpSingle();
        subject.single(sportClass, footballClass);
    }

    public void testInstance() {
        setUpInstance();
        subject.instance(cerealClass, cocoPops);
    }

    public void testFactoryByRef() {
        expect.oneCall(factoriesMock, VOID, "add", factoryDummy);
        subject.factory(factoryDummy);
    }

    public void testFactoryByClassSucceeds() {
        expect.nu(factoryDummy, soapFactoryClass, NO_ARGS);
        expect.oneCall(factoriesMock, VOID, "add", factoryDummy);
        subject.factory(soapFactoryClass);
    }

    private void setUpInstance() {
        expect.oneCall(instancesMock, VOID, "put", cerealInterface, resolvedCocoPops);
    }

    private void setUpMultiple() {
        Blueprint multipleFootballBlueprint = blueprint(MULTIPLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, multipleFootballBlueprint);
    }

    private void setUpSingle() {
        Blueprint singleFootballBlueprint = blueprint(SINGLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, singleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class football) {
        Implementation impl = new DefaultImplementation(football);
        return new DefaultBlueprint(stamp, impl);
    }
}
