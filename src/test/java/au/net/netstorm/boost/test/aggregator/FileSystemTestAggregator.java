package au.net.netstorm.boost.test.aggregator;

import junit.framework.Test;
import junit.framework.TestSuite;

public final class FileSystemTestAggregator implements TestAggregator {
    private final ClassLocator classLocator = new TestClassLocator();
    private Class starter;

    public FileSystemTestAggregator(Class starter) {
        this.starter = starter;
    }

    public Test aggregate(String suiteName, String regex) {
        Class[] matches = findMatches(regex, starter);
        return buildSuite(suiteName, matches);
    }

    private Class[] findMatches(String regex, Class starter) {
        RegexPattern expression = new TestRegexPattern(regex);
        return classLocator.locate(starter, expression);
    }

    private Test buildSuite(String suiteName, Class[] classes) {
        TestSuite result = new TestSuite(suiteName);
        for (int i = 0; i < classes.length; i++) {
            result.addTestSuite(classes[i]);
        }
        return result;
    }
}
