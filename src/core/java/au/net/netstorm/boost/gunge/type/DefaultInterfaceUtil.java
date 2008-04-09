package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.nursery.util.type.DefaultInterface;

public final class DefaultInterfaceUtil implements InterfaceUtil {
    public Interface[] interfaces(Class[] classes) {
        Interface[] result = new Interface[classes.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new DefaultInterface(classes[i]);
        }
        return result;
    }
}