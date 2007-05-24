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
    Class iface;
    WebSpinner webSpinner;

    public void setupSubjects() {
        subject = new DefaultRegistry(webSpinner);
    }

    public void testPrototype() {
        expect.oneCall(webSpinner, VOID, "implementation", sportInterface, footballImplementation);
        subject.prototype(sport, football);
    }

    public void testInstance() {
        expect.oneCall(webSpinner, VOID, "instance", cerealInterface, resolvedCocoPops);
        subject.instance(cereal, cocoPops);
    }
}
