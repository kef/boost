package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.type.Implementation;

public interface ConstructorMaster {
    Type[] getGenericParameterTypes(Implementation impl);
}
