package au.net.netstorm.boost.sniper.reflect.util;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;

public class DefaultClassTestUtil implements ClassTestUtil {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private static final Object[] NO_PARAMETERS = {};

    // FIX SC509 Reorder parameters?
    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return isAssignable(type, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return isAssignable(superClass, subClass);
    }

    public boolean isSubInterfaceOf(Interface superInterface, Interface subInterface) {
        Class superType = superInterface.getType();
        Class subType = subInterface.getType();
        return isAssignable(superType, subType);
    }

    public Object newInstance(Class type) {
        Constructor constructor = reflector.getConstructor(type);
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, NO_PARAMETERS);
    }

    public boolean isInstantiable(Class<?> type) {
        Constructor[] ctors = type.getDeclaredConstructors();
        if (ctors.length != 1) return false;
        Class<?>[] signature = ctors[0].getParameterTypes();
        return signature.length == 0;
    }

    private boolean isAssignable(Class superType, Class subType) {
        return superType.isAssignableFrom(subType);
    }
}
