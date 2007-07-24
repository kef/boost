package au.net.netstorm.boost.nursery.edgify;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 33398 Use ClassMaster for some of these private methods.  Add getPackage to ClassMaster.
public final class DefaultEdgifierHorizon implements EdgifierHorizon {
    private static final String DOT = ".";
    private static final String EDGE_INTERFACE_PREFIX = "";
    private static final String EDGE_CLASS_NAME_PREFIX = "Default" + EDGE_INTERFACE_PREFIX;
    private EdgeClass classer = new DefaultEdgeClass();
    private final String prefix;

    DefaultEdgifierHorizon(String prefix) {
        this.prefix = prefix;
    }

    public Class toReal(Class edgeClass) {
        String packageStripped = stripEdgePackage(edgeClass);
        String className = getShortName(edgeClass);
        String strippedName = stripOffPrefix(className, EDGE_INTERFACE_PREFIX, edgeClass);
        String realName = packageStripped + DOT + strippedName;
        return classer.forName(realName);
    }

    public Class toEdge(Class realClass) {
        String pkgName = getPackage(realClass);
        String shortName = getShortName(realClass);
        String edgeName = prefix + pkgName + DOT + EDGE_CLASS_NAME_PREFIX + shortName;
        return classer.forName(edgeName);
    }

    private String stripEdgePackage(Class edgeClass) {
        String pkgName = getPackage(edgeClass);
        return stripOffPrefix(pkgName, prefix, edgeClass);
    }

    private String stripOffPrefix(String packageName, String prefix, Class edgeClass) {
        boolean prefixed = packageName.startsWith(prefix);
        if (!prefixed) throw new IllegalStateException("Not an edge class " + edgeClass);
        int length = prefix.length();
        return packageName.substring(length);
    }

    private String getShortName(Class cls) {
        String fullName = cls.getName();
        return getShortName(fullName);
    }

    private String getShortName(String fullName) {
        int lastDot = fullName.lastIndexOf(DOT);
        return fullName.substring(lastDot + 1);
    }

    private String getPackage(Class cls) {
        String fullName = cls.getName();
        return getPackage(fullName);
    }

    private String getPackage(String fullName) {
        int lastDot = fullName.lastIndexOf(DOT);
        return fullName.substring(0, lastDot);
    }
}
