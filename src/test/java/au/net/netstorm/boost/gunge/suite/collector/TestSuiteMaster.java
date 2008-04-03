package au.net.netstorm.boost.gunge.suite.collector;

public interface TestSuiteMaster {
    <T extends BoostSuite> TestSuites suite(Class<T> suiteCls);
}
