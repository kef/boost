package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryAtomicTest extends InteractionTestCase {
    Registry subject;
    Class frenchCloison = FrenchCloison.class;
    Class frenchRoll = FrenchRoll.class;
    Class davidPetit = DavidPetit.class;
    Damien damienInstance = new Damien();
    Interface cloisonInterface = new DefaultInterface(frenchCloison);
    Interface rollInterface = new DefaultInterface(frenchRoll);
    Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    Instance rollInstance = new DefaultInstance(damienInstance);
    Class iface;
    RegisterMaster registerMaster;
    Boolean hasImplementation;
    Boolean hasInstance;
    Interface someInterface;
    Implementation implementation;
    Instance instance;
    Class implClass;
    Object ref;

    public void setupSubjects() {
        subject = new DefaultRegistry(registerMaster);
    }

    public void testPrototype() {
        expect.oneCall(registerMaster, VOID, "prototype", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(registerMaster, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, damienInstance);
    }
}
