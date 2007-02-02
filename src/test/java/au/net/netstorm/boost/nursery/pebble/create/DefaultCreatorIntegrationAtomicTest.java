package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;

public final class DefaultCreatorIntegrationAtomicTest extends PrimordialTestCase implements UsesMocks {
    private MockExpectations expect;
    // FIX 1665 fix
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InvocationHandler invocationHandler;
    private EdgeProxySupplier edgeProxySupplier;
    private ProxyFactory proxyFactory;

    public void setupSubjects() {
    }

    // FIX 1665 Remove
    public void testNothing() {
    }

    // FIX 1665 Reinstate when DefaultCreatorProxySupplier is impl'ed
    public void brokenTestThatWeCanCreateAFred() {
        CreatorProxySupplier creatorProxySupplier =
                new DefaultCreatorProxySupplier(proxyFactory,invocationHandler);
        TedCreator tedCreatorImpl = (TedCreator) creatorProxySupplier.create(new DefaultInterface(TedCreator.class));
        NedCreator nedCreatorImpl = (NedCreator) creatorProxySupplier.create(new DefaultInterface(NedCreator.class));
        new Fred(tedCreatorImpl, nedCreatorImpl);
    }
    
    private class Ted {}
    private class Ned {}

    private interface TedCreator {
        Ted create();
    }

    private interface NedCreator {
        Ned create();
    }

    private class Fred {
        private TedCreator tedCreator;
        private NedCreator nedCreator;

        public Fred(TedCreator tedCreator, NedCreator nedCreator) {
            this.tedCreator = tedCreator;
            this.nedCreator = nedCreator;
        }

        public void doStuff() {
            Ted ted = tedCreator.create();
            doStuffWithTed(ted);
            Ned ned = nedCreator.create();
            doStuffWithNed(ned);
        }

        private void doStuffWithNed(Ned ned) {

        }

        private void doStuffWithTed(Ted ted) {
            // do nothing
        }
    }
}
