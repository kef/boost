package au.net.netstorm.boost.spider.linkage;

import java.lang.reflect.Field;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

// FIX 2363 some of these are only called from tests (atomic) -- remove??
// FIX 2363 generally making this smaller would be good, my opinion is wider interfaces nearer to the edge
// FIX 2363 internal interfaces should be narrower
public interface LinkageFactory {
    Linkage nu(Field field);

    Linkage nu(Class iface);

    Linkage nu(Class host, Class iface);

    Linkage nu(Class host, Class iface, String name);

    Linkage nu(Interface iface);

    Linkage nu(Implementation host, Interface iface);

    Linkage nu(Implementation host, Interface iface, String name);

    // FIX 2363 remove some of the above methods and use this one in preference
    Linkage nu(Implementation host, Interface iface, Anchor anchor);
}
