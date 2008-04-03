package au.net.netstorm.boost.gunge.aggregator;

import junit.framework.Test;

public interface TestAggregator {
    Test aggregate(String suiteName, String regex);
}
