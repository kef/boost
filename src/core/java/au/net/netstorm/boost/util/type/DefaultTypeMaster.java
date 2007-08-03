package au.net.netstorm.boost.util.type;

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

    // FIX BREADCRUMB 1887 Impl me.
    public Interface[] interfaces(Interface iface) {
        return null;
    }

    public Interface[] declaredInterfaces(Implementation impl) {
        Class implClass = impl.getImpl();
        Class[] ifaces = implClass.getInterfaces();
        return convertToInterfaces(ifaces);
    }

    private Interface[] convertToInterfaces(Class[] ifaces) {
        Interface[] result = new Interface[ifaces.length];
        for (int i = 0; i < ifaces.length; i++) {
            result[i] = new DefaultInterface(ifaces[i]);
        }
        return result;
    }
}
