package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryAtomicTest extends InteractionTestCase
        implements HasFixtures, LazyFields {
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    Class sport = Sport.class;
    Class cereal = BreakfastCereal.class;
    Class football = Football.class;
    CocoPops cocoPops = new CocoPops();
    Interface sportInterface = new DefaultInterface(sport);
    Interface cerealInterface = new DefaultInterface(cereal);
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    Blueprints blueprintsMock;
    Instances instancesMock;
    Factories factoriesMock;
    Factory factoryDummy;
    Registry subject;

    public void setUpFixtures() {
        subject = new DefaultRegistry(blueprintsMock, instancesMock, factoriesMock);
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

    public void testFactory() {
        expect.oneCall(factoriesMock, VOID, "add", factoryDummy);
        subject.factory(factoryDummy);
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
