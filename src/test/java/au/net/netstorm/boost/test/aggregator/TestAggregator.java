package au.net.netstorm.boost.test.aggregator;

import junit.framework.Test;

public interface TestAggregator {
    Test aggregate(String suiteName, String regex);
}
