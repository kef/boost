package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class TestClassLocator implements ClassLocator {
    private final ClassNameLocator classNameLocator = new TestClassNameLocator();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public Class[] locate(Class starter, RegexPattern pattern) {
        JavaClass[] javaClasses = classNameLocator.locate(starter, pattern);
        int length = javaClasses.length;
        Class[] result = new Class[length];
        for (int i = 0; i < length; i++) {
            result[i] = buildClass(javaClasses[i]);
        }
        return result;
    }

    private Class buildClass(JavaClass javaClass) {
        String fullyQualified = javaClass.getFullyQualified();
        return edgeClass.forName(fullyQualified);
    }
}
