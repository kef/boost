package au.net.netstorm.boost.demo.pebble;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.demo.pebble.fixtures.Bob;
import au.net.netstorm.boost.demo.pebble.fixtures.ConstructorInjection;
import au.net.netstorm.boost.demo.pebble.fixtures.JobCreator;
import au.net.netstorm.boost.demo.pebble.fixtures.NedCreator;
import au.net.netstorm.boost.demo.pebble.fixtures.Rob;
import au.net.netstorm.boost.demo.pebble.fixtures.TedCreator;
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
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// DEBT LineLength {
public final class DefaultCreatorDemoTest extends TestCase {
    private GenericCreator genericCreator = new DefaultGenericCreator();
    private InvocationHandler invocationHandler = new CreatorInvocationHandler(genericCreator);
    private ProxySupplier proxySupplier = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    private CreatorProxySupplier creatorProxySupplier = new DefaultCreatorProxySupplier(proxyFactory, invocationHandler);
    private CreatorFieldFinder creatorFieldFinder = new DefaultCreatorFieldFinder();

    public void testFieldInjectionWithDependencies() {
        Rob rob = createRob();
        rob.doStuff();
        Bob bob = rob.getBob();
        JobCreator newJobCreator = bob.getNewJobCreator();
        assertNotNull("newJobCreator should have been created as a dependency", newJobCreator);
    }

    public void testConstructorInjection() {
        TedCreator tedCreatorProxy = (TedCreator) createProxy(TedCreator.class);
        NedCreator nedCreatorProxy = (NedCreator) createProxy(NedCreator.class);
        ConstructorInjection constructorInjection = new ConstructorInjection(tedCreatorProxy, nedCreatorProxy);
        constructorInjection.doStuff();
    }

    private Rob createRob() {
        Rob rob = new Rob();
        // FIX 1665 We should be calling the creator here and not the injector.
        CreatorProxyInjector creatorProxyInjector = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorProxyInjector.inject(rob);
        return rob;
    }

    private Object createProxy(Class cls) {
        Interface clsInterface = new DefaultInterface(cls);
        return creatorProxySupplier.create(clsInterface);
    }
}
// } DEBT LineLength