package au.net.netstorm.boost.spider.linkage;

import java.lang.reflect.Field;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public class DefaultLinkageFactory implements LinkageFactory {
    public Linkage nu(Field field) {
        Class host = field.getDeclaringClass();
        Class iface = field.getType();
        String name = field.getName();
        return nu(host, iface, name);
    }

    public Linkage nu(Class iface) {
        return nu(null, iface, null);
    }

    public Linkage nu(Class host, Class iface) {
        return nu(host, iface, null);
    }

    public Linkage nu(Class host, Class iface, String name) {
        Implementation h = host(host);
        Interface i = new DefaultInterface(iface);
        return nu(h, i, name);
    }

    public Linkage nu(Interface iface) {
        return nu(null, iface, null);
    }

    public Linkage nu(Implementation host, Interface iface) {
        return nu(host, iface, null);
    }

    public Linkage nu(Implementation host, Interface iface, String name) {
        // FIX 2363 still to be pushed further out.
        Anchor anchor = name != null ? new DefaultAnchor(name) : null;
        return new DefaultLinkage(host, iface, anchor);
    }

    private Implementation host(Class host) {
        if (host == null) return null;
        return new DefaultImplementation(host);
    }
}
