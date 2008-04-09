package au.net.netstorm.boost.gunge.type;

import java.util.HashSet;
import java.util.Set;

public final class DefaultTypeMaster implements TypeMaster {
    private final InterfaceUtil util = new DefaultInterfaceUtil();

    public boolean implementz(Implementation impl, Interface iface) {
        Class cls = impl.getImpl();
        Class iFace = iface.getType();
        return iFace.isAssignableFrom(cls);
    }

    public boolean extendz(Interface iface, Interface superIface) {
        Class superClass = superIface.getType();
        Class cls = iface.getType();
        return superClass.isAssignableFrom(cls);
    }

    public Interface[] declaredInterfaces(Implementation impl) {
        Class implClass = impl.getImpl();
        return declaredInterfaces(implClass);
    }

    public Interface[] interfaces(Interface iface) {
        Class cls = iface.getType();
        Set set = new HashSet();
        interfaces(set, cls);
        return toInterfaces(set);
    }

    public Interface[] interfaces(Implementation impl) {
        Class cls = impl.getImpl();
        Class[] ifaces = cls.getInterfaces();
        Set set = new HashSet();
        interfaces(set, ifaces);
        return toInterfaces(set);
    }

    public Interface[] declaredInterfaces(Interface iface) {
        Class cls = iface.getType();
        return declaredInterfaces(cls);
    }

    private Interface[] declaredInterfaces(Class cls) {
        Class[] ifaces = cls.getInterfaces();
        return util.interfaces(ifaces);
    }

    private void interfaces(Set set, Class[] ifaces) {
        for (Class iface : ifaces) {
            interfaces(set, iface);
        }
    }

    private void interfaces(Set set, Class iface) {
        set.add(iface);
        Class[] ifaces = iface.getInterfaces();
        interfaces(set, ifaces);
    }

    private Interface[] toInterfaces(Set set) {
        Class[] result = (Class[]) set.toArray(new Class[]{});
        return util.interfaces(result);
    }
}
