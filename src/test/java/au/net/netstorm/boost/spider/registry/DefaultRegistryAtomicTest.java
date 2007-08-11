package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    Registry subject;
    Class sport = Sport.class;
    Class cereal = BreakfastCereal.class;
    Class football = Football.class;
    CocoPops cocoPops = new CocoPops();
    Interface sportInterface = new DefaultInterface(sport);
    Interface cerealInterface = new DefaultInterface(cereal);
    Blueprint footballBlueprint = blueprint(football);
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    Flavour unflavoured = Flavour.UNFLAVOURED;
    String stringFlavour;
    Flavour flavour;
    BlueprintMaster blueprinterMock;
    InstanceMaster instancerMock;

    public void setUpFixtures() {
        flavour = new DefaultFlavour(stringFlavour);
        subject = new DefaultRegistry(blueprinterMock, instancerMock);
    }

    public void testMultipleUnflavoured() {
        setUpMultiple(unflavoured);
        subject.multiple(sport, football);
    }

    public void testMultipleFlavoured() {
        setUpMultiple(flavour);
        subject.multiple(sport, football, stringFlavour);
    }

    public void testInstanceUnflavoured() {
        setUpInstance(unflavoured);
        subject.instance(cereal, cocoPops);
    }

    public void testInstanceflavoured() {
        setUpInstance(flavour);
        subject.instance(cereal, cocoPops, stringFlavour);
    }

    private void setUpInstance(Flavour flavour) {
        expect.oneCall(instancerMock, MockExpectations.VOID, "instance", cerealInterface, resolvedCocoPops, flavour);
    }

    private void setUpMultiple(Flavour flavour) {
        expect.oneCall(blueprinterMock, MockExpectations.VOID, "blueprint", sportInterface, footballBlueprint, flavour);
    }

    private Blueprint blueprint(Class football) {
        Implementation impl = new DefaultImplementation(football);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl);
    }
}
