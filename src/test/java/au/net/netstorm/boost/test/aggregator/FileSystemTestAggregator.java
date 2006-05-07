package au.net.netstorm.boost.test.aggregator;

import java.io.File;

import au.net.netstorm.boost.java.lang.reflect.DefaultEdgeReflect;
import au.net.netstorm.boost.java.lang.reflect.EdgeReflect;
import junit.framework.Test;
import junit.framework.TestSuite;

public final class FileSystemTestAggregator implements TestAggregator {
    private final ClassLocator locator = new TestClassLocator();
    private final EdgeReflect reflect = new DefaultEdgeReflect();
    private final File root;

    public FileSystemTestAggregator(File root) {
        this.root = root;
    }

    public Test aggregate(String suiteName, String regex) {
        JavaClass[] matches = findMatches(regex, root);
        return buildSuite(suiteName, matches);
    }

    private JavaClass[] findMatches(String regex, File root) {
        RegexPattern expression = new TestRegexPattern(regex);
        return locator.locate(root, expression);
    }

    private Test buildSuite(String suiteName, JavaClass[] classes) {
        TestSuite result = new TestSuite(suiteName);
        for (int i = 0; i < classes.length; i++) addClass(classes[i], result);
        return result;
    }

    private void addClass(JavaClass clsName, TestSuite result) {
        String qualified = clsName.getFullyQualified();
        Class cls = reflect.forName(qualified);
        result.addTestSuite(cls);
    }
}
