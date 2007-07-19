package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMaster implements ImplMaster {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private ClassMaster classMaster = new DefaultClassMaster();

    public Implementation defaultImpl(Interface iFace) {
        String defaultClassName = defaultImplName(iFace);
        Class impl = edgeClass.forName(defaultClassName);
        return new DefaultImplementation(impl);
    }

    public boolean hasDefaultImpl(Interface iFace) {
        try {
            defaultImpl(iFace);
            return true;
        } catch (EdgeException e) {
            return false;
        }
    }

    private String defaultImplName(Interface iFace) {
        String packageName = classMaster.getPackageName(iFace);
        String className = classMaster.getShortName(iFace);
        return packageName + ".Default" + className;
    }
}
