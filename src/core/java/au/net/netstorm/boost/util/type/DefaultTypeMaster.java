package au.net.netstorm.boost.util.type;

import java.util.HashSet;
import java.util.Set;

public final class DefaultTypeMaster implements TypeMaster {

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

    public Interface[] interfaces(Interface iface) {
        Class cls = iface.getType();
        Set set = new HashSet();
        interfaces(set, cls);
        return toInterfaces(set);
    }

    private void interfaces(Set set, Class[] ifaces) {
        for (int i = 0; i < ifaces.length; i++) {
            Class iface = ifaces[i];
            interfaces(set, iface);
        }
    }

    private void interfaces(Set set, Class iface) {
        set.add(iface);
        Class[] ifaces = iface.getInterfaces();
        interfaces(set, ifaces);
    }

    public Interface[] declaredInterfaces(Implementation impl) {
        Class implClass = impl.getImpl();
        Class[] ifaces = implClass.getInterfaces();
        return toInterfaces(ifaces);
    }

    private Interface[] toInterfaces(Set set) {
        Class[] result = (Class[]) set.toArray(new Class[]{});
        return toInterfaces(result);
    }

    private Interface[] toInterfaces(Class[] ifaces) {
        Interface[] result = new Interface[ifaces.length];
        for (int i = 0; i < ifaces.length; i++) {
            result[i] = new DefaultInterface(ifaces[i]);
        }
        return result;
    }
}
