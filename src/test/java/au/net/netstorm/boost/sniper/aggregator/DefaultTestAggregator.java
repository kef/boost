package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;
import junit.framework.Test;

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