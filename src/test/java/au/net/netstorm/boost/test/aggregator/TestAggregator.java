package au.net.netstorm.boost.test.aggregator;

import java.io.File;

import au.net.netstorm.boost.reflect.DefaultReflectEdge;
import au.net.netstorm.boost.reflect.ReflectEdge;
import junit.framework.Test;
import junit.framework.TestSuite;

// FIXME: SC043 Most of this is plain utility code.  All except this class.  Move to utility area.
// FIXME: SC043 Check out any other classes which can use Edges as well.
// FIXME: SC043 Does it make sense to use the java.classpath system property?

public class TestAggregator {
    private static final String KEY_TEST_CLASSPATH = "test.classpath";
    private static final String ENCOURAGEMENT_NOTICE = "---------> THIS IS SIMPLE TO FIX <---------   ";
    private final ReflectEdge reflect = new DefaultReflectEdge();
    private final ClassLocator locator = new DefaultClassLocator();

    public Test aggregate(String suiteName, String regex) {
        DefaultClassName[] matches = findMatches(regex);
        return buildSuite(suiteName, matches);
    }

    private DefaultClassName[] findMatches(String regex) {
        File root = getRoot();
        RegexPattern expression = new RegexPattern(regex);
        return locator.locate(root, expression);
    }

    private Test buildSuite(String suiteName, DefaultClassName[] classes) {
        TestSuite result = new TestSuite(suiteName);
        for (int i = 0; i < classes.length; i++) addClass(classes[i], result);
        return result;
    }

    private void addClass(ClassName clsName, TestSuite result) {
        String qualified = clsName.getFullyQualified();
        Class cls = reflect.forName(qualified);
        result.addTestSuite(cls);
    }

    private File getRoot() {
        String property = getRootProperty();
        return new File(property);
    }

    private String getRootProperty() {
        String property = System.getProperty(KEY_TEST_CLASSPATH);
        if (property != null) return property;
        return fail();
    }

    private String fail() {
        String message = buildUserMessage();
        throw new RuntimeException(message, null);
    }

    private String buildUserMessage() {
        return ENCOURAGEMENT_NOTICE + "Ensure you have set the " + KEY_TEST_CLASSPATH + " property to point to your compiled test class hierarchy.";
    }
}