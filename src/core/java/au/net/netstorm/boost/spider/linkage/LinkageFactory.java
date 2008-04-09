package au.net.netstorm.boost.spider.linkage;

import java.lang.reflect.Field;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public interface LinkageFactory {
    Linkage nu(Field field);

    Linkage nu(Class iface);

    Linkage nu(Class host, Class iface);

    Linkage nu(Class host, Class iface, String name);

    Linkage nu(Interface iface);

    Linkage nu(Implementation host, Interface iface);

    Linkage nu(Implementation host, Interface iface, String name);
}
