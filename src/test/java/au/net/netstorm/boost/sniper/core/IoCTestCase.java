package au.net.netstorm.boost.sniper.core;

// FIX 2394 temporary step, i think the ioc should not be in the test class hierachy, rather in the lifecycle somewhere.
// FIX 2394 seperate out IoC required for framework vs IoC required for code under test.
public abstract class IoCTestCase extends CleanTestCase {

}
