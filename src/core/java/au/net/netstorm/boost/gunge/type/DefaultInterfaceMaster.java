package au.net.netstorm.boost.gunge.type;

public final class DefaultInterfaceMaster implements InterfaceMaster {
    public Interface[] interfaces(Class[] classes) {
        Interface[] result = new Interface[classes.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new DefaultInterface(classes[i]);
        }
        return result;
    }

    public Class[] classes(Interface[] types) {
        Class[] result = new Class[types.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = types[i].getType();
        }
        return result;
    }
}