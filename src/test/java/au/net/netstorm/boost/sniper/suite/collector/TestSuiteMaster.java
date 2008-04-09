package au.net.netstorm.boost.sniper.suite.collector;

public interface TestSuiteMaster {
    <T extends BoostSuite> TestSuites suite(Class<T> suiteCls);
}
