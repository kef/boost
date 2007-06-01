package au.net.netstorm.boost.spider.resolve;

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

    public void setupSubjects() {
        subject = new DefaultRegistry(registryMaster);
    }

    public void testMultiple() {
        // FIX 1977 No nulls.
        expect.oneCall(registryMaster, VOID, "multiple", sportInterface, footballImplementation, null);
        subject.multiple(sport, football);
    }

    public void testInstance() {
        // FIX 1977 No nulls.
        expect.oneCall(registryMaster, VOID, "instance", cerealInterface, resolvedCocoPops, null);
        subject.instance(cereal, cocoPops);
    }
}
