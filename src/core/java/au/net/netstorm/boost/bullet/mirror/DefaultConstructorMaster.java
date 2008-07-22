package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Type;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.Implementation;

public final class DefaultConstructorMaster implements ConstructorMaster {
    private final ReflectMaster reflector = new DefaultReflectMaster();

    public Type[] getGenericParameterTypes(Implementation impl) {
        Constructor constructor = reflector.getConstructor(impl);
        return constructor.getGenericParameterTypes();
    }
}
