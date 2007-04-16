package au.net.netstorm.boost.nursery.edgify;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import junit.framework.Assert;

public final class DefaultEdgePackageChecker implements EdgeChecker {
    private static final String DEFAULT_EDGE = "DefaultEdge";
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final List checkExceptions = new ArrayList();
    private final String packagePrefix;

    public DefaultEdgePackageChecker(String packagePrefix) {
        this.packagePrefix = packagePrefix;
        checkExceptions.add(DefaultEdgifierHorizon.class);
    }

    public void check(Class cls) {
        if (checkExceptions.contains(cls)) return;
        String shortName = classMaster.getShortName(cls);
        String packageName = classMaster.getPackageName(cls);
        String className = cls.getName();
        checkEdgePackage(packageName, shortName);
        checkRealPackage(className);
    }

    private void checkRealPackage(String className) {
        String realClsPackage = getRealClassPackage(className);
        String realClsShortName = getRealClassShortName(className);
        String realCls = realClsPackage + "." + realClsShortName;
        checkClassExists(realCls);
    }

    private String getRealClassShortName(String className) {
        int defaultEdgeLength = DEFAULT_EDGE.length();
        int defaultEdgeIndex = className.lastIndexOf(DEFAULT_EDGE);
        int endOfDefaultEdge = defaultEdgeIndex + defaultEdgeLength;
        return className.substring(endOfDefaultEdge);
    }

    private String getRealClassPackage(String className) {
        int prefixLength = packagePrefix.length();
        int lastIndexOfDot = className.lastIndexOf(".");
        return className.substring(prefixLength, lastIndexOfDot);
    }

    private void checkClassExists(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            Assert.fail("Edge class for " + className + " is not in the correct edge package.");
        }
    }

    private void checkEdgePackage(String packageName, String shortName) {
        boolean isEdgePackage = packageName.startsWith(packageName);
        if (!isEdgePackage) Assert.fail(shortName + " must live in the edge package.");
    }
}
