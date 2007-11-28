package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class NewerFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields, InjectableSubject {
    private static final Interface TED = new DefaultInterface(Ted.class);
    private static final Interface NEW_TED = new DefaultInterface(NewTed.class);
    TypeMaster typer = new DefaultTypeMaster();
    ResolvedInstance instance;
    ProviderEngine providerDummy;
    Implementation hostDummy;
    NewerAssembler assemblerMock;
    NewerFactory subject;
    Newer refMock;

    public void setUpFixtures() {
        subject = new NewerFactory();
        instance = new DefaultBaseReference(refMock);
    }

    public void testGet() {
        expect.oneCall(assemblerMock, refMock, "assemble", NEW_TED, providerDummy);
        ResolvedInstance actual = subject.get(NEW_TED, hostDummy, providerDummy);
        assertEquals(instance, actual);
    }

    public void testCanHandle() {
        checkCanHandle(NEW_TED, true);
        checkCanHandle(TED, false);
    }

    public void testIsSingle() {
        boolean actual = subject.isSingle(NEW_TED);
        assertEquals(true, actual);
    }

    private void checkCanHandle(Interface iface, boolean expected) {
        boolean actual = subject.canHandle(iface);
        assertEquals(expected, actual);
    }
}
