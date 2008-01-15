package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.Field;

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

    public Linkage nu(Implementation host, Interface impl, String name) {
        return new DefaultLinkage(host, impl, name);
    }

    private Implementation host(Class host) {
        if (host == null) return null;
        return new DefaultImplementation(host);
    }
}
