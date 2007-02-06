package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import junit.framework.TestCase;

// FIX 1665 Move into Demo.  This is what it is.

// FIX 1665 Dodgy.  Tidy up.  Remove dupe.
public final class DefaultCreatorMolecularTest extends TestCase {
    private GenericCreator genericCreator = new DefaultGenericCreator();
    private InvocationHandler invocationHandler = new CreatorInvocationHandler(genericCreator);
    private ProxySupplier proxySupplier = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    private CreatorProxySupplier creatorProxySupplier =
            new DefaultCreatorProxySupplier(proxyFactory, invocationHandler);

    // FIX 1665 Reintroduce when we're done.
    public void testReintroduce() {
    }
/*
    public void testFredCallsCreatorsFromConstructor() {
        TedCreator tedCreatorImpl = (TedCreator) creatorProxySupplier.create(new DefaultInterface(TedCreator.class));
        NedCreator nedCreatorImpl = (NedCreator) creatorProxySupplier.create(new DefaultInterface(NedCreator.class));
        Fred fred = new Fred(tedCreatorImpl, nedCreatorImpl);
        fred.doStuff();
    }

    // FIX 1665 Remove when done.
    public void brokenTestRobCallsInjectedFieldCreators() {
        Rob rob = new Rob();
        CreatorProxyInjector creatorProxyInjector =
                new DefaultCreatorProxyInjector(creatorProxySupplier);
        creatorProxyInjector.inject(rob);
        rob.doStuff();
    }

    // FIX 1665 Leave here for demo purposes.
    public void wiringTest() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
        GenericCreator genericCreator = new DefaultGenericCreator();
        InvocationHandler bar = new CreatorInvocationHandler(genericCreator);
        CreatorProxySupplier creatorProxySupplier = new DefaultCreatorProxySupplier(proxyFactory, bar);
        CreatorProxyInjector creatorProxyInjector = new DefaultCreatorProxyInjector(creatorProxySupplier);
    }
*/
}
