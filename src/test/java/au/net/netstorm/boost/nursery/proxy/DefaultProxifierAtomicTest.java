package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.InjectableTest;
import au.net.netstorm.boost.gunge.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.register.Registry;

// FIX 2248 Complete.
public final class DefaultProxifierAtomicTest extends LifecycleTestCase implements InjectableTest, OverlaysWeb {
    Claustrophobe claustrophobe;
    LayerSpec layerSpec;
    Proxifier subject;

    public void overlay(Registry registry) {
        registry.single(LayerSpec.class, ClaustrophobicLayerSpec.class);
    }

    public void testProxy() {
        Claustrophobe closed = subject.proxy(claustrophobe, layerSpec);
        closed.panic();
    }
}