package au.net.netstorm.boost.gunge.suite.collector;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public class DefaultTestSuiteMaster implements TestSuiteMaster {
    EdgeClass classer = new DefaultEdgeClass();

    public <T extends BoostSuite> TestSuites suite(Class<T> suiteCls) {
        BoostSuite booster = (BoostSuite) classer.newInstance(suiteCls);
        return booster.suites();
    }
}
