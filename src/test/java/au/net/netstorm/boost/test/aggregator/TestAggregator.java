/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.test.aggregator;

import junit.framework.Test;

public interface TestAggregator {
    Test aggregate(String suiteName, String regex);
}
