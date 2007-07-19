package au.net.netstorm.boost.util.type;

public final class DefaultTypeMaster implements TypeMaster {

    public boolean implementz(Implementation impl, Interface iface) {
        Class aClass = impl.getImpl();
        Class iFace = iface.getType();
        return iFace.isAssignableFrom(aClass);
    }

    public boolean extendz(Interface iFace, Interface superIface) {
        Class superClass = superIface.getType();
        Class cls = iFace.getType();
        return superClass.isAssignableFrom(cls);
    }

    public Interface[] getInterfaces(Implementation impl) {
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