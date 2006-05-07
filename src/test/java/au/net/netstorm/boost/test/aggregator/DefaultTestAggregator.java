package au.net.netstorm.boost.test.aggregator;

import java.io.File;

import au.net.netstorm.boost.java.lang.DefaultEdgeSystem;
import au.net.netstorm.boost.java.lang.EdgeSystem;
import junit.framework.Test;

// FIXME: SC043 Check out any other classes which can use Edges as well.
// FIXME: SC043 Does it make sense to use the java.classpath system property?
// FIXME: SC043 We should split this so the core functionality does not rely on a system property.
// FIXME: SC043 In other words, grab the property then delegate.

public class DefaultTestAggregator implements TestAggregator {
    private static final String KEY_TEST_CLASSPATH = "test.classpath";
    private static final String ENCOURAGEMENT_NOTICE = "---------> THIS IS SIMPLE TO FIX <---------   ";
    private final EdgeSystem system = new DefaultEdgeSystem();

    public Test aggregate(String suiteName, String regex) {
        File root = getRoot();
        TestAggregator aggregator = new FileSystemTestAggregator(root);
        return aggregator.aggregate(suiteName, regex);
    }

    private File getRoot() {
        String property = getRootProperty();
        return new File(property);
    }

    private String getRootProperty() {
        String property = system.getProperty(KEY_TEST_CLASSPATH);
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