package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
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
    Blueprint multipleFootballBlueprint = blueprint(MULTIPLE, football);
    Blueprint singleFootballBlueprint = blueprint(SINGLE, football);
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    Flavour unflavoured = Flavour.UNFLAVOURED;
    String stringFlavour;
    Flavour flavoured;
    Blueprints blueprintsMock;
    Instances instancesMock;
    Registry subject;

    // FIX 2081 Add single tests.
    public void setUpFixtures() {
        flavoured = new DefaultFlavour(stringFlavour);
        subject = new DefaultRegistry(blueprintsMock, instancesMock);
    }

    public void testMultipleUnflavoured() {
        setUpMultiple(unflavoured);
        subject.multiple(sport, football);
    }

    public void testMultipleFlavoured() {
        setUpMultiple(flavoured);
        subject.multiple(sport, football, stringFlavour);
    }

    public void testSingleUnflavoured() {
        setUpSingle(unflavoured);
        subject.single(sport, football);
    }

    public void testSingleFlavoured() {
        setUpSingle(flavoured);
        subject.single(sport, football, stringFlavour);
    }

    public void testInstanceUnflavoured() {
        setUpInstance(unflavoured);
        subject.instance(cereal, cocoPops);
    }

    public void testInstanceflavoured() {
        setUpInstance(flavoured);
        subject.instance(cereal, cocoPops, stringFlavour);
    }

    private void setUpInstance(Flavour flavour) {
        // FIX 2081 VOID into interface.
        expect.oneCall(instancesMock, VOID, "put", cerealInterface, flavour, resolvedCocoPops);
    }

    private void setUpMultiple(Flavour flavour) {
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, flavour, multipleFootballBlueprint);
    }

    private void setUpSingle(Flavour flavour) {
        expect.oneCall(blueprintsMock, VOID, "put", sportInterface, flavour, singleFootballBlueprint);
    }

    private Blueprint blueprint(Stamp stamp, Class football) {
        Implementation impl = new DefaultImplementation(football);
        return new DefaultBlueprint(stamp, impl);
    }
}
