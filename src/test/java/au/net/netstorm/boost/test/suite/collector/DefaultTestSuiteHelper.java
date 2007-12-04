package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.aggregator.DefaultFileSystemLocator;
import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.FileSystemLocator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import junit.framework.Test;

import java.io.File;

public class DefaultTestSuiteHelper implements TestSuiteHelper {
    private final FileSystemLocator locator = new DefaultFileSystemLocator();
    private final String testType;
    private final Class classInTree;

    public DefaultTestSuiteHelper(String testType, Class classInTree) {
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
