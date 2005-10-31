package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;

public interface ReflectObjectMaster {
    // FIXME: SC509 This is really part of IOC.  Not plain old primordial stuff.
    Object create(Class cls);

    Constructor getConstructor(Class cls);
}
