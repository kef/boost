package au.net.netstorm.boost.gunge.aggregator;

import java.io.File;
import junit.framework.Test;
import junit.framework.TestSuite;

public final class FileSystemTestAggregator implements TestAggregator {
    private final ClassLocator locator = new TestClassLocator();
    private File root;

    public FileSystemTestAggregator(File root) {
        this.root = root;
    }

    public Test aggregate(String suiteName, String regex) {
        Class[] matches = matches(regex);
        return buildSuite(suiteName, matches);
    }

    private Class[] matches(String regex) {
        RegexPattern expression = new TestRegexPattern(regex);
        return locator.locate(root, expression);
    }

    private Test buildSuite(String suiteName, Class[] classes) {
        TestSuite result = new TestSuite(suiteName);
        for (Class cls : classes) result.addTestSuite(cls);
        return result;
    }
}
