package au.net.netstorm.boost.testing.aggregator;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;

// FIXME: SC506 Most of this is plain utility code.  All except this class.  Move to utility area.
// FIXME: SC506 Instancise.
// FIXME: SC506 Check out any other classes which can use Edges as well.
public class TestSuiteAggregator {
    private static final String KEY_TEST_CLASSPATH = "test.classpath";

    public static Test aggregate(String name, String regex) {
        TestSuite result = new TestSuite(name);
        ClassLocator locator = new ClassLocator();
        ClassName[] classes = locator.locate(getRoot(), new RegexPattern(regex));
        for (int i = 0; i < classes.length; i++) result.addTestSuite(forName(classes, i));
        return result;
    }

    private static File getRoot() {
        String property = System.getProperty(KEY_TEST_CLASSPATH);
        if (property == null)
            throw new RuntimeException("Ensure you have set the " + KEY_TEST_CLASSPATH + " property to point to your compiled test class hierarchy.", null);
        return new File(property);
    }

    // FIXME: ? SC511 Can this use the ClassEdge.
    private static Class forName(ClassName[] classes, int i) {
        try {
            return Class.forName(classes[i].getFullyQualified());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}