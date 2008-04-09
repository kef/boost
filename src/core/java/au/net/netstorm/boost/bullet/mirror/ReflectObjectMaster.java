package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;

public interface ReflectObjectMaster {
    Constructor getConstructor(Class cls);
}
