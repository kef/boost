package au.net.netstorm.boost;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;

public final class DefaultClassNameMorpher implements ClassNameMorpher {
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
        int length = prefix.length();
        return shortName.substring(length);
    }
}
