package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.scalpel.engine.EdgePackage;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.registry.Registry;

public abstract class EdgeDemooooTest extends LifecycleTestCase implements OverlaysWeb, InjectableTest {
    public final void overlay(Registry registry) {
        registry.single(EdgePackage.class, DemoEdgePackage.class);
    }
}
