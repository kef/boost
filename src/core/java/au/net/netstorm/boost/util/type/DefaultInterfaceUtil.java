package au.net.netstorm.boost.util.type;

public final class DefaultInterfaceUtil implements InterfaceUtil {
    public Interface[] interfaces(Class[] classes) {
        int length = classes.length;
        Interface[] result = new Interface[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new DefaultInterface(classes[i]);
        }
        return result;
    }
}