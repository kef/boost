package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class TestClassLocator implements ClassLocator {
    private final ClassNameLocator locator = new TestClassNameLocator();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public Class[] locate(File root, RegexPattern pattern) {
        JavaClass[] javaClasses = locator.locate(root, pattern);
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
