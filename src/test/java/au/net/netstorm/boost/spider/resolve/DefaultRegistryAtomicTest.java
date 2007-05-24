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
    Class frenchCloison = Sport.class;
    Class frenchRoll = BreakfastCereal.class;
    Class davidPetit = Football.class;
    CocoPops cocoPopsInstance = new CocoPops();
    Interface cloisonInterface = new DefaultInterface(frenchCloison);
    Interface rollInterface = new DefaultInterface(frenchRoll);
    Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    ResolvedInstance rollInstance = new DefaultBaseReference(cocoPopsInstance);
    Class iface;
    WebSpinner webSpinner;

    public void setupSubjects() {
        subject = new DefaultRegistry(webSpinner);
    }

    public void testPrototype() {
        expect.oneCall(webSpinner, VOID, "implementation", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(webSpinner, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, cocoPopsInstance);
    }
}
