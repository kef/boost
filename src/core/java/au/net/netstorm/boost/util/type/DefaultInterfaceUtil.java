package au.net.netstorm.boost.util.type;

public final class DefaultInterfaceUtil implements InterfaceUtil {
    public Interface[] interfaces(Class[] classes) {
        Interface[] result = new Interface[classes.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new DefaultInterface(classes[i]);
        }
        return result;
    }
}