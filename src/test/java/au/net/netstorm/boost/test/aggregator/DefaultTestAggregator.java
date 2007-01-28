package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.net.URL;
import junit.framework.Test;

public class DefaultTestAggregator implements TestAggregator {
    private final Class classInTestTree;
    private static final String PATH_ROOT = "/";

    public DefaultTestAggregator(Class classInTestTree) {
        this.classInTestTree = classInTestTree;
    }

    public Test aggregate(String suiteName, String regex) {
        File root = getRoot();
        TestAggregator aggregator = new FileSystemTestAggregator(root);
        return aggregator.aggregate(suiteName, regex);
    }

    private File getRoot() {
        URL resource = classInTestTree.getResource(PATH_ROOT);
        String testRoot = resource.getFile();
        return new File(testRoot);
    }
}