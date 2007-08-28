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
        String name = defaultImplName(iface);
        Class impl = classer.forName(name);
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
        String pkg = master.getPackageName(iFace);
        String cls = master.getShortName(iFace);
        return pkg + ".Default" + cls;
    }
}
