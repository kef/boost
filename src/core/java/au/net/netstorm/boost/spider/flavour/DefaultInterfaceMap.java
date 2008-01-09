package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Interface;

import java.util.HashMap;
import java.util.Map;

// FIX 2237 Move any non-flavoured stuff out of the package and clean.

// FIX ()   2237 Rename to NiceMap.
public final class DefaultInterfaceMap implements InterfaceMap {
    private final Map ifaces = new HashMap();
    // Leave in for test framework to tweak
    private static boolean overridesAllowed = false;

    public void put(Interface iface, Object value) {
        if (value == null) fail(iface, "Come on, ya have to give me somethin' man.  Anything but a null");
        validate(iface);
        ifaces.put(iface, value);
    }

    public Object get(Interface iface) {
        Object result = nullGet(iface);
        if (result == null) fail(iface, "No matching interface");
        return result;
    }

    public boolean exists(Interface iface) {
        return nullGet(iface) != null;
    }

    public Object nullGet(Interface iface) {
        return ifaces.get(iface);
    }

    private void validate(Interface iface) {
        if (overridesAllowed) return;
        if (ifaces.containsKey(iface)) fail(iface, "Interface already exists");
    }

    private void fail(Interface iface, String msg) {
        throw new InterfaceMapException(iface, msg);
    }
}
