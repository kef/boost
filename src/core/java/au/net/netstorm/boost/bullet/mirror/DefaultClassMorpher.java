package au.net.netstorm.boost.bullet.mirror;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultClassMorpher implements ClassMorpher {
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public Class stripPrefix(String prefix, Class cls) {
        String packageName = classMaster.getPackageName(cls);
        String shortName = classMaster.getShortName(cls);
        String morphedName = stripPrefix(prefix, shortName);
        String morphedClassName = packageName + "." + morphedName;
        return edgeClass.forName(morphedClassName);
    }

    private String stripPrefix(String prefix, String shortName) {
        if (!isPrefixIn(prefix, shortName))
            throw new IllegalArgumentException(prefix + " is not a prefix of " + shortName);
        int length = prefix.length();
        return shortName.substring(length);
    }

    private boolean isPrefixIn(String prefix, String shortName) {
        return shortName.startsWith(prefix);
    }
}
