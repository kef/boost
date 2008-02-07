package au.net.netstorm.boost.test.suite.collector;

public interface TestSuiteMaster {
    <T extends BoostSuite> TestSuites suite(Class<T> suiteCls);
}
