package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

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
        return filterOutInterfaces(result);
    }

    private Class buildClass(JavaClass javaClass) {
        String fullyQualified = javaClass.getFullyQualified();
        return edgeClass.forName(fullyQualified);
    }

    private Class[] filterOutInterfaces(Class[] classes) {
        List result = new ArrayList();
        for (Class cls : classes) {
            if (!cls.isInterface()) result.add(cls);
        }
        return (Class[]) result.toArray(new Class[]{});
    }
}
