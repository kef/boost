package au.net.netstorm.boost.sniper.suite.collector;

import java.io.File;
import au.net.netstorm.boost.sniper.aggregator.DefaultFileSystemLocator;
import au.net.netstorm.boost.sniper.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.sniper.aggregator.FileSystemLocator;
import au.net.netstorm.boost.sniper.aggregator.TestAggregator;
import junit.framework.Test;

public class FileBasedTestSuites implements TestSuites {
    private final FileSystemLocator locator = new DefaultFileSystemLocator();
    private final String testType;
    // SUGGEST (Dec 7, 2007): 819257 Experiment with an arbitrary classInTree.
    private final Class classInTree;

    public FileBasedTestSuites(String testType, Class classInTree) {
        this.testType = testType;
        this.classInTree = classInTree;
    }

    public Test suite(String name, File root) {
        TestAggregator aggregator = new DefaultTestAggregator(root);
        String pattern = ".*" + testType + "Test";
        return aggregator.aggregate(testType, pattern);
    }

    public Test suite() {
        File root = locator.locate(classInTree);
        return suite(testType, root);
    }
}
