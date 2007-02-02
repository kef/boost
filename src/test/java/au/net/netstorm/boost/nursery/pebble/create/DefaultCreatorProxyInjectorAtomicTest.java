package au.net.netstorm.boost.nursery.pebble.create;

import junit.framework.TestCase;

public final class DefaultCreatorProxyInjectorAtomicTest extends TestCase {
    private CreatorProxyInjector creatorProxyInjector = new DefaultCreatorProxyInjector();

    // FIX BREADCRUMB 1665 
    public void testInject() {
        Object object = new Object();
        creatorProxyInjector.inject(object);
    }
}
