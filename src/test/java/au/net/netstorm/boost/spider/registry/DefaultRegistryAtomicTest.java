package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    Registry subject;
    Class sport = Sport.class;
    Class cereal = BreakfastCereal.class;
    Class football = Football.class;
    CocoPops cocoPops = new CocoPops();
    Interface sportInterface = new DefaultInterface(sport);
    Interface cerealInterface = new DefaultInterface(cereal);
    Implementation footballImplementation = new DefaultImplementation(football);
    ResolvedInstance resolvedCocoPops = new DefaultBaseReference(cocoPops);
    RegistryMaster registryMaster;
    Flavour unflavoured = Flavour.UNFLAVOURED;
    String stringFlavour;
    Flavour flavour;

    public void setupSubjects() {
        flavour = new DefaultFlavour(stringFlavour);
        subject = new DefaultRegistry(registryMaster);
    }

    public void testMultipleUnflavoured() {
        setupMultiple(unflavoured);
        subject.multiple(sport, football);
    }

    public void testMultipleFlavoured() {
        setupMultiple(flavour);
        subject.multiple(sport, football, stringFlavour);
    }

    public void testInstanceUnflavoured() {
        setupInstance(unflavoured);
        subject.instance(cereal, cocoPops);
    }

    public void testInstanceflavoured() {
        setupInstance(flavour);
        subject.instance(cereal, cocoPops, stringFlavour);
    }

    private void setupInstance(Flavour flavour) {
        expect.oneCall(registryMaster, VOID, "instance", cerealInterface, resolvedCocoPops, flavour);
    }

    private void setupMultiple(Flavour flavour) {
        expect.oneCall(registryMaster, VOID, "multiple", sportInterface, footballImplementation, flavour);
    }
}
