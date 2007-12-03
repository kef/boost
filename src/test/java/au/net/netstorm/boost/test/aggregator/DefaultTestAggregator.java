package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import junit.framework.Test;

public class DefaultTestAggregator implements TestAggregator {
    private final FileSystemLocator locator = new DefaultFileSystemLocator();
    private final Class classInTestTree;

    public DefaultTestAggregator(Class classInTestTree) {
        this.classInTestTree = classInTestTree;
    }

    public Test aggregate(String suiteName, String regex) {
        File root = locator.locate(classInTestTree);
        TestAggregator aggregator = new FileSystemTestAggregator(root);
        return aggregator.aggregate(suiteName, regex);
    }
}