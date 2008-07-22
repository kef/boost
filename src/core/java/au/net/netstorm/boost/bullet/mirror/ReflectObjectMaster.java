package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.Implementation;

public interface ReflectObjectMaster {
    Constructor getConstructor(Class cls);

    Constructor getConstructor(Implementation impl);
}
