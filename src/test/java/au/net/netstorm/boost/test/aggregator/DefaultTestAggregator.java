package au.net.netstorm.boost.test.aggregator;

import junit.framework.Test;

public class DefaultTestAggregator implements TestAggregator {
    private final Class classInTestTree;

    public DefaultTestAggregator(Class classInTestTree) {
        this.classInTestTree = classInTestTree;
    }

    public Test aggregate(String suiteName, String regex) {
        TestAggregator aggregator = new FileSystemTestAggregator(classInTestTree);
        return aggregator.aggregate(suiteName, regex);
    }
}