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
    private EdgeClass classer = new DefaultEdgeClass();
    private ClassMaster master = new DefaultClassMaster();

    public Implementation defaultImpl(Interface iface) {
        String defaultClassName = defaultImplName(iface);
        Class impl = classer.forName(defaultClassName);
        return new DefaultImplementation(impl);
    }

    public boolean hasDefaultImpl(Interface iface) {
        try {
            defaultImpl(iface);
            return true;
        } catch (EdgeException e) {
            return false;
        }
    }

    private String defaultImplName(Interface iFace) {
        String packageName = master.getPackageName(iFace);
        String className = master.getShortName(iFace);
        return packageName + ".Default" + className;
    }
}
