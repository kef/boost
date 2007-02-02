package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import junit.framework.TestCase;

public final class DefaultCreatorIntegrationAtomicTest extends TestCase {
    private Creator creator = new DefaultCreator();
    private InvocationHandler invocationHandler = new DefaultCreatorInvocationHandler(creator);
    private DefaultEdgeProxySupplier proxySupplier = new DefaultEdgeProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);

    public void testThatWeCanCreateAFred() {
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
            // do nothing
        }

        private void doStuffWithTed(Ted ted) {
            // do nothing
        }
    }
}
