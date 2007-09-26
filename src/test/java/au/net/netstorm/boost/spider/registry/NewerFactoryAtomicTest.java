package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerFactoryAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Interface TED = new DefaultInterface(Ted.class);
    private static final Interface NEW_TED = new DefaultInterface(NewTed.class);
    ResolvedInstance newerInstance;
    ProviderEngine providerDummy;
    Implementation hostDummy;
    NewerAssembler newerMock;
    Instances instancesMock;
    NewerFactory subject;
    Newer refMock;

    public void setUpFixtures() {
        subject = new NewerFactory(newerMock);
        newerInstance = new DefaultBaseReference(refMock);
    }

    public void testGet() {
        expect.oneCall(newerMock, refMock, "assemble", NEW_TED);
        expect.oneCall(instancesMock, VOID, "put", NEW_TED, newerInstance);
        ResolvedInstance actual = subject.get(NEW_TED, hostDummy, providerDummy, instancesMock);
        assertEquals(newerInstance, actual);
    }

    public void testCanHandle() {
        checkCanHandle(NEW_TED, true);
        checkCanHandle(TED, false);
    }

    private void checkCanHandle(Interface iface, boolean expected) {
        boolean actual = subject.canHandle(iface);
        assertEquals(expected, actual);
    }
}
