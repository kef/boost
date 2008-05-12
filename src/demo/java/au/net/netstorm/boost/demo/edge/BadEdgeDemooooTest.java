package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.guts.EdgePackage;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.registry.Registry;

public abstract class BadEdgeDemooooTest extends LifecycleTestCase implements OverlaysWeb, InjectableTest {
    public final void overlay(Registry registry) {
        registry.single(EdgePackage.class, BadDemoEdgePackage.class);
    }
}
