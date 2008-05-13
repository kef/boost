package au.net.netstorm.boost.sniper.suite.collector;

import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public class DefaultTestSuiteMaster implements TestSuiteMaster {
    EdgeClass classer = new DefaultEdgeClass();

    public <T extends BoostSuite> TestSuites suite(Class<T> suiteCls) {
        BoostSuite booster = (BoostSuite) classer.newInstance(suiteCls);
        return booster.suites();
    }
}
