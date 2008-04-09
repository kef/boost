package au.net.netstorm.boost.sniper.aggregator;

import junit.framework.Test;

public interface TestAggregator {
    Test aggregate(String suiteName, String regex);
}
