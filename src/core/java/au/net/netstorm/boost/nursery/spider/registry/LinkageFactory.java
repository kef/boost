package au.net.netstorm.boost.nursery.spider.registry;

import java.lang.reflect.Field;

public interface LinkageFactory {
    Linkage nu(Field field);

    Linkage nu(Class iface);

    Linkage nu(Class host, Class iface);

    Linkage nu(Class host, Class iface, String name);
}
