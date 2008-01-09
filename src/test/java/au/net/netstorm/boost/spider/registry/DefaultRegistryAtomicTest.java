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
    private static final Object[] NO_ARGS = {};
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    private static final Implementation NO_HOST = new DefaultImplementation(Object.class);
    Class soapFactoryClass = SoapFactory.class;
    Class cerealClass = BreakfastCereal.class;
    Class footballClass = Football.class;
    Class sportClass = Sport.class;
    Class footballStadiumClass = FootballStadium.class;
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface sportInterface = new DefaultInterface(sportClass);
    Interface cerealInterface = new DefaultInterface(cerealClass);
    Implementation footballStadiumInterface = new DefaultImplementation(footballStadiumClass);
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

    // FIX ()   2237 Incorporate hosts for multiple (definitely) and instances (maybe)???
    public void setUpFixtures() {
        subject = new DefaultRegistry(blueprintsMock, instancesMock, factoriesMock, nuMock);
    }

    public void testMultiple() {
        setUpMultiple();
        subject.multiple(sportClass, footballClass);
    }

    public void testSingle() {
        Blueprint blueprint = blueprint(SINGLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", NO_HOST, sportInterface, blueprint);
        subject.single(sportClass, footballClass);
    }

    public void testHostedSingle() {
        Blueprint blueprint = blueprint(SINGLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", footballStadiumInterface, sportInterface, blueprint);
        subject.single(footballStadiumClass, sportClass, footballClass);
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
        expect.oneCall(blueprintsMock, VOID, "put", NO_HOST, sportInterface, multipleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class football) {
        Implementation impl = new DefaultImplementation(football);
        return new DefaultBlueprint(stamp, impl, NO_ARGS);
    }
}
