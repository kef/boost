package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import static au.net.netstorm.boost.spider.register.Stamp.SINGLE;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX BREADCRUMB   2237 Check return values.

// FIX   2237 Complete.
public final class DefaultRegistryAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_ARGS = {};
    private static final Object[] NO_PARAMS = {};
    private Class soapFactoryClass = SoapFactory.class;
    private Class cerealClass = BreakfastCereal.class;
    private Class pantryClass = Pantry.class;
    private Class cocoPopsClass = CocoPops.class;
    private Interface cerealIface = new DefaultInterface(cerealClass);
    private Implementation pantryImpl = new DefaultImplementation(pantryClass);
    private CocoPops cocoPops = new CocoPops();
    private Implementation cocoPopsImpl = new DefaultImplementation(CocoPops.class);
    private ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    private Blueprint blueprint = new DefaultBlueprint(SINGLE, cocoPopsImpl, NO_PARAMS);
    private LinkageFactory linkageFactory = new DefaultLinkageFactory();
    private Linkage cerealLinkage = linkageFactory.nu(cerealIface);
    private Linkage cerealPantryLinkage = linkageFactory.nu(pantryImpl, cerealIface);
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
        subject.multiple(cerealClass, cocoPopsClass);
    }

    public void testSingle() {
        Blueprint blueprint = blueprint(SINGLE, cocoPopsClass);
        expect.oneCall(blueprintsMock, VOID, "put", cerealLinkage, blueprint);
        subject.single(cerealClass, cocoPopsClass);
    }

    public void testHostedSingle() {
        Blueprint blueprint = blueprint(SINGLE, cocoPopsClass);
        expect.oneCall(blueprintsMock, VOID, "put", cerealPantryLinkage, blueprint);
        subject.single(pantryClass, cerealClass, cocoPopsClass);
    }

    public void testFullSingle() {
        Blueprint blueprint = blueprint(SINGLE, cocoPopsClass);
        Linkage linkage = linkageFactory.nu(pantryImpl, cerealIface, name);
        expect.oneCall(blueprintsMock, VOID, "put", linkage, blueprint);
        subject.single(pantryClass, cerealClass, name, cocoPopsClass);
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
        expect.oneCall(instancesMock, VOID, "put", cerealIface, cocoPopsImpl, resolvedCocoPops);
    }

    private void setUpMultiple() {
        Blueprint multipleFootballBlueprint = blueprint(Stamp.MULTIPLE, cocoPopsClass);
        expect.oneCall(blueprintsMock, VOID, "put", cerealLinkage, multipleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(stamp, impl, NO_ARGS);
    }
}
