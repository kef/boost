package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.sniper.automock.DefaultMockSupport;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.sniper.marker.ProvidesData;
import au.net.netstorm.boost.sniper.specific.BoostDataProviders;

// FIX 2394 use or lose. specified in IoCTestCase to replace the framework() method from LifecycleTestCase.
public final class SniperSpiderConfig implements SpiderConfig {
    Binder binder;

    public void configure() {
        // FIX 2130 MAG This is dupe (localised).  Discuss and resolve.
        // FIX 2394 yeh, there is a couple of fixes floating around.
        // FIX 2394 I think the best idea is a multiplicity wrapper around binder
        // FIX 2394 eg. multiplicity.single(MockSupport.class)
        binder.bind(MockSupport.class).toSingle(DefaultMockSupport.class);
        binder.bind(TestLifecycleBlocks.class).toSingle(BoostTestLifecycleBlocks.class);
        binder.bind(ProvidesData.class).toSingle(BoostDataProviders.class);
    }
}
