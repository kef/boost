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
    private StampedResolvedInstance stamped;
    ResolvedInstance instance;
    ProviderEngine providerDummy;
    Implementation hostDummy;
    NewerAssembler newerMock;
    NewerFactory subject;
    Newer refMock;

    public void setUpFixtures() {
        subject = new NewerFactory(newerMock);
        instance = new DefaultBaseReference(refMock);
        stamped = new DefaultStampedResolvedInstance(instance, Stamp.SINGLE);
    }

    public void testGet() {
        expect.oneCall(newerMock, refMock, "assemble", NEW_TED, providerDummy);
        StampedResolvedInstance actual = subject.get(NEW_TED, hostDummy, providerDummy);
        assertEquals(stamped, actual);
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
