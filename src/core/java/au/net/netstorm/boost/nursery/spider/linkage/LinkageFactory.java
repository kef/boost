package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.Field;

public interface LinkageFactory {
    Linkage nu(Field field);

    Linkage nu(Class iface);

    Linkage nu(Class host, Class iface);

    Linkage nu(Class host, Class iface, String name);

    Linkage nu(Interface iface);

    Linkage nu(Implementation host, Interface iface);

    Linkage nu(Implementation host, Interface impl, String name);
}