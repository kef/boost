package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultRegistryAtomicTest extends InteractionTestCase
        implements HasFixtures, LazyFields {
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    Class soapFactory = SoapFactory.class;
    Class cereal = BreakfastCereal.class;
    Class football = Football.class;
    Class sport = Sport.class;
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface sportInterface = new DefaultInterface(sport);
    Interface cerealInterface = new DefaultInterface(cereal);
    CocoPops cocoPops = new CocoPops();
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    Blueprints blueprintsMock;
    Instances instancesMock;
    Factories factoriesMock;
    EdgeClass classerMock;
    Injector injectorMock;
    TypeMaster typerMock;
    Factory factoryDummy;
    Registry subject;

    public void setUpFixtures() {
        subject = new DefaultRegistry(blueprintsMock, instancesMock, factoriesMock, injectorMock);
        fielder.setInstance(subject, "classer", classerMock);
        fielder.setInstance(subject, "typer", typerMock);
    }

    public void testMultiple() {
        setUpMultiple();
        subject.multiple(sport, football);
    }

    public void testSingle() {
        setUpSingle();
        subject.single(sport, football);
    }

    public void testInstance() {
        setUpInstance();
        subject.instance(cereal, cocoPops);
    }

    public void testFactoryByRef() {
        expect.oneCall(factoriesMock, VOID, "add", factoryDummy);
        subject.factory(factoryDummy);
    }

    public void testFactoryByClassSucceeds() {
        setUpFactoryCheck(true);
        expect.oneCall(classerMock, factoryDummy, "newInstance", soapFactory);
        expect.oneCall(injectorMock, VOID, "inject", factoryDummy);
        expect.oneCall(factoriesMock, VOID, "add", factoryDummy);
        subject.factory(soapFactory);
    }

    public void testFactoryByClassFails() {
        setUpFactoryCheck(false);
        try {
            subject.factory(soapFactory);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void setUpFactoryCheck(boolean isFactory) {
        Implementation impl = new DefaultImplementation(soapFactory);
        Interface iface = new DefaultInterface(Factory.class);
        expect.oneCall(typerMock, isFactory, "implementz", impl, iface);
    }

    private void setUpInstance() {
        expect.oneCall(instancesMock, VOID, "put", cerealInterface, resolvedCocoPops);
    }

    private void setUpMultiple() {
        Blueprint multipleFootballBlueprint = blueprint(MULTIPLE, football);
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, multipleFootballBlueprint);
    }

    private void setUpSingle() {
        Blueprint singleFootballBlueprint = blueprint(SINGLE, football);
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, singleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class football) {
        Implementation impl = new DefaultImplementation(football);
        return new DefaultBlueprint(stamp, impl);
    }
}
