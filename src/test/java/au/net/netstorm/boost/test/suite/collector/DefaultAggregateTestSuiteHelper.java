package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import au.net.netstorm.boost.test.aggregator.DefaultFileSystemLocator;
import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.FileSystemLocator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import junit.framework.Test;

public class DefaultAggregateTestSuiteHelper implements AggregateTestSuiteHelper {
    private final FileSystemLocator locator = new DefaultFileSystemLocator();
    private final String testType;
    // FIX (Dec 5, 2007) CORE SPLIT 87471 Experiment with an arbitrary classInTree.
    private final Class classInTree;

    public DefaultAggregateTestSuiteHelper(String testType, Class classInTree) {
        this.testType = testType;
        this.classInTree = classInTree;
    }

    public Test suite(File root) {
        TestAggregator aggregator = new DefaultTestAggregator(root);
        String pattern = ".*" + testType + "Test";
        return aggregator.aggregate(testType, pattern);
    }

    public Test suite() {
        File root = locator.locate(classInTree);
        return suite(root);
    }
}
