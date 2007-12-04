package au.net.netstorm.boost.test.aggregator;

import junit.framework.Test;

import java.io.File;

public class DefaultTestAggregator implements TestAggregator {
    private final File root;

    public DefaultTestAggregator(File root) {
        this.root = root;
    }

    public Test aggregate(String suiteName, String regex) {
        TestAggregator aggregator = new FileSystemTestAggregator(root);
        return aggregator.aggregate(suiteName, regex);
    }
}