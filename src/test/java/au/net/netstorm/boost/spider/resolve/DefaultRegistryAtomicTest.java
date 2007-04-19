package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryAtomicTest extends InteractionTestCase {
    Registry subject;
    Class frenchCloison = FrenchCloison.class;
    Class frenchRoll = FrenchRoll.class;
    Class davidPetit = DavidPetit.class;
    Damien damienInstance = new Damien();
    Interface cloisonInterface = new DefaultInterface(frenchCloison);
    Interface rollInterface = new DefaultInterface(frenchRoll);
    Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    ResolvedInstance rollInstance = new DefaultBaseReference(damienInstance);
    Class iface;
    RegistryMaster registryMaster;
    Boolean hasImplementation;
    Boolean hasInstance;
    Interface someInterface;
    Implementation implementation;
    ResolvedInstance instance;
    Class implClass;
    Object ref;
    Interface[] interfaces;

    public void setupSubjects() {
        subject = new DefaultRegistry(registryMaster);
    }

    public void testPrototype() {
        expect.oneCall(registryMaster, VOID, "implementation", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(registryMaster, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, damienInstance);
    }
}
