package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.sniper.lifecycle.CallSetupFixtures;
import au.net.netstorm.boost.sniper.lifecycle.DataRegisterer;
import au.net.netstorm.boost.sniper.lifecycle.InjectTest;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.ValidateTest;

// FIX 2394 delete. this is temporary only until migration from old to nu.
public final class NuSpiderTestLifecycleBlocks implements TestLifecycleBlocks {
    public Class[] getPre() {
        return new Class[] {
            ValidateTest.class,
            DataRegisterer.class,
            InjectTest.class,
            CallSetupFixtures.class,
        };
    }

    public Class[] getPost() {
        return new Class[0];
    }

    public Class[] getCleanup() {
        return new Class[0];
    }
}
