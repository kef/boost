package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import junit.framework.Test;
import junit.framework.TestSuite;

public final class FileSystemTestAggregator implements TestAggregator {
    private final ClassNameLocator nameLocator = new TestClassNameLocator();
    private final EdgeClass edgeClass = new DefaultEdgeClass();
    private Class starter;

    public FileSystemTestAggregator(Class starter) {
        this.starter = starter;
    }

    public Test aggregate(String suiteName, String regex) {
        JavaClass[] matches = findMatches(regex, starter);
        return buildSuite(suiteName, matches);
    }

    private JavaClass[] findMatches(String regex, Class starter) {
        RegexPattern expression = new TestRegexPattern(regex);
        return nameLocator.locate(starter, expression);
    }

    private Test buildSuite(String suiteName, JavaClass[] classes) {
        TestSuite result = new TestSuite(suiteName);
        for (int i = 0; i < classes.length; i++) {
            addClass(classes[i], result);
        }
        return result;
    }

    private void addClass(JavaClass clsName, TestSuite result) {
        String qualified = clsName.getFullyQualified();
        Class cls = edgeClass.forName(qualified);
        result.addTestSuite(cls);
    }
}
