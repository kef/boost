package au.net.netstorm.boost.test.reflect;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeReflect;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeReflect;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultClassTestUtil implements ClassTestUtil {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeReflect reflectEdge = new DefaultEdgeReflect();
    private static final Object[] NO_PARAMETERS = {};

    // FIXME: SC509 Reorder parameters?
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
        return reflectEdge.newInstance(constructor, NO_PARAMETERS);
    }

    private boolean isAssignable(Class superType, Class subType) {
        return superType.isAssignableFrom(subType);
    }
}
