package au.net.netstorm.boost.demo.pebble;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.nursery.pebble.create.CreatorFieldFinder;
import au.net.netstorm.boost.nursery.pebble.create.CreatorInvocationHandler;
import au.net.netstorm.boost.nursery.pebble.create.CreatorProxyInjector;
import au.net.netstorm.boost.nursery.pebble.create.CreatorProxySupplier;
import au.net.netstorm.boost.nursery.pebble.create.DefaultCreatorFieldFinder;
import au.net.netstorm.boost.nursery.pebble.create.DefaultCreatorProxyInjector;
import au.net.netstorm.boost.nursery.pebble.create.DefaultCreatorProxySupplier;
import au.net.netstorm.boost.nursery.pebble.create.DefaultGenericCreator;
import au.net.netstorm.boost.nursery.pebble.create.GenericCreator;
import au.net.netstorm.boost.nursery.pebble.create.fixtures.ConstructorInjection;
import au.net.netstorm.boost.nursery.pebble.create.fixtures.NedCreator;
import au.net.netstorm.boost.nursery.pebble.create.fixtures.Rob;
import au.net.netstorm.boost.nursery.pebble.create.fixtures.TedCreator;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIX BREADCRUMB 1665 -10000000 Move all fixtures in here.
// FIX 1665 Move into Demo.  This is what it is.
// FIX 1665 This does not get run as part of the atomic tests.

// FIX 1665 Dodgy.  Tidy up.  Remove dupe.

// DEBT LineLength {
public final class DefaultCreatorMolecularTest extends TestCase {
    private GenericCreator genericCreator = new DefaultGenericCreator();
    private InvocationHandler invocationHandler = new CreatorInvocationHandler(genericCreator);
    private ProxySupplier proxySupplier = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    private CreatorProxySupplier creatorProxySupplier = new DefaultCreatorProxySupplier(proxyFactory, invocationHandler);
    private CreatorFieldFinder creatorFieldFinder = new DefaultCreatorFieldFinder();

    public void testFieldInjection() {
        primeRob();
    }

    // FIX 1665 Re-instate.
//    public void testMoreGoodiesAtThe32FloorOfWaterFrontPlace() {
//        Rob rob = primeRob();
//        Bob bob = rob.bob;
//        assertNotNull("What Master Gwegowy wants", bob.newJobCreator);
//    }

    public void testConstructorInjection() {
        TedCreator tedCreatorProxy = (TedCreator) createProxy(TedCreator.class);
        NedCreator nedCreatorProxy = (NedCreator) createProxy(NedCreator.class);
        ConstructorInjection constructorInjection = new ConstructorInjection(tedCreatorProxy, nedCreatorProxy);
        constructorInjection.doStuff();
    }

    private Rob primeRob() {
        Rob rob = new Rob();
        CreatorProxyInjector creatorProxyInjector = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorProxyInjector.inject(rob);
        rob.doStuff();
        return rob;
    }

    private Object createProxy(Class cls) {
        Interface clsInterface = new DefaultInterface(cls);
        return creatorProxySupplier.create(clsInterface);
    }
}
// } DEBT LineLength