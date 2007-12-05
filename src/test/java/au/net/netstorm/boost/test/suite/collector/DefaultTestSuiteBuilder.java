package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import junit.framework.TestSuite;

public class DefaultTestSuiteBuilder implements TestSuiteBuilder {
    private static final Object[] NO_ARGS = {};
    private static final Class[] NO_TYPES = {};
    private static final Object NO_INSTANCE = null;
    private static final Class[] FILE_TYPE = new Class[]{File.class};
    EdgeClass classer = new DefaultEdgeClass();
    EdgeMethod methoder = new DefaultEdgeMethod();
    private final String name;
    private final Class[] suites;

    public DefaultTestSuiteBuilder(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        return doSuite(NO_ARGS);
    }

    public TestSuite suite(File root) {
        Object[] args = {root};
        return doSuite(args);
    }

    private TestSuite doSuite(Object[] args) {
        TestSuite result = new TestSuite(name);
        for (Class suiteCls : suites) {
            TestSuite suite = createSuite(suiteCls, args);
            result.addTest(suite);
        }
        return result;
    }

    private TestSuite createSuite(Class suiteCls, Object[] args) {
        Class[] argTypes = getArgTypes(args);
        // FIX (Dec 5, 2007) CORE SPLIT 87471 Move these two lines into MethodTestUtil.
        Method method = classer.getMethod(suiteCls, "suite", argTypes);
        return (TestSuite) methoder.invoke(method, NO_INSTANCE, args);
    }

    private Class[] getArgTypes(Object[] args) {
        if (args.length == 0) return NO_TYPES;
        return FILE_TYPE;
    }
}
