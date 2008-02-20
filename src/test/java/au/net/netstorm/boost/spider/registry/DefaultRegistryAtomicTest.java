package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.nursery.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX BREADCRUMB   2237 Tidy this up!

// FIX   2237 Complete.
public final class DefaultRegistryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_ARGS = {};
    private static final Object[] NO_PARAMS = {};
    private Class soapFactoryClass = SoapFactory.class;
    private Class cerealClass = BreakfastCereal.class;
    private Class pantryClass = Pantry.class;
    private Class footballClass = Football.class;
    private Class sportClass = Sport.class;
    private Class footballStadiumClass = FootballStadium.class;
    private Interface sportInterface = new DefaultInterface(sportClass);
    private Interface cerealInterface = new DefaultInterface(cerealClass);
    private Implementation footballStadiumImplementation = new DefaultImplementation(footballStadiumClass);
    private CocoPops cocoPops = new CocoPops();
    private Implementation cocoPopsImplementation = new DefaultImplementation(CocoPops.class);
    private ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    private Blueprint blueprint = new DefaultBlueprint(SINGLE, cocoPopsImplementation, NO_PARAMS);
    private LinkageFactory linkageFactory = new DefaultLinkageFactory();
    private Linkage sportLinkage = linkageFactory.nu(sportInterface);
    private Linkage sportStadiumLinkage = linkageFactory.nu(footballStadiumImplementation, sportInterface);
    private Linkage cerealLinkage = linkageFactory.nu(cerealInterface);
    private Implementation pantryImpl = new DefaultImplementation(pantryClass);
    private Linkage cerealPantryLinkage = linkageFactory.nu(pantryImpl, cerealInterface);
    Blueprints blueprintsMock;
    Instances instancesMock;
    Factories factoriesMock;
    Factory factoryDummy;
    Layers proxiesMock;
    Registry subject;
    String name;
    Nu nuMock;

    // FIX ()   2237 Incorporate hosts for multiple (definitely) and instances (maybe)???
    public void setUpFixtures() {
        subject = new DefaultRegistry(blueprintsMock, instancesMock, factoriesMock, proxiesMock, nuMock);
    }

    public void testMultiple() {
        setUpMultiple();
        subject.multiple(sportClass, footballClass);
    }

    public void testSingle() {
        Blueprint blueprint = blueprint(SINGLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", sportLinkage, blueprint);
        subject.single(sportClass, footballClass);
    }

    public void testHostedSingle() {
        Blueprint blueprint = blueprint(SINGLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", sportStadiumLinkage, blueprint);
        subject.single(footballStadiumClass, sportClass, footballClass);
    }

    public void testFullSingle() {
        Blueprint blueprint = blueprint(SINGLE, footballClass);
        Linkage linkage = linkageFactory.nu(footballStadiumImplementation, sportInterface, name);
        expect.oneCall(blueprintsMock, VOID, "put", linkage, blueprint);
        subject.single(footballStadiumClass, sportClass, name, footballClass);
    }

    public void testInstance() {
        setUpInstance(cerealLinkage);
        subject.instance(cerealClass, cocoPops);
    }

    // SUGGEST: looks like "hosted instances" are a hack.
    public void testHostedInstance() {
        setUpInstance(cerealPantryLinkage);
        subject.instance(pantryClass, cerealClass, cocoPops);
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

    private void setUpInstance(Linkage linkage) {
        expect.oneCall(blueprintsMock, VOID, "put", linkage, blueprint);
        expect.oneCall(instancesMock, VOID, "put", cerealInterface, cocoPopsImplementation, resolvedCocoPops);
    }

    private void setUpMultiple() {
        Blueprint multipleFootballBlueprint = blueprint(Stamp.MULTIPLE, footballClass);
        expect.oneCall(blueprintsMock, VOID, "put", sportLinkage, multipleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(stamp, impl, NO_ARGS);
    }
}
