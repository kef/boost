package au.net.netstorm.boost.pebble.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.type.NoCreatorInterfaceException;
import au.net.netstorm.boost.pebble.type.NonMatchingCreatorException;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleChecker implements PebbleChecker {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class impl) {
        Interface creator = getCreator(impl);
        Class[] parameters = getConstructorParameters(impl);
        tryGetMethod(creator, impl, parameters);
    }

    private Interface getCreator(Class impl) {
        String creatorClassName = insertNewIntoName(impl.getName());
        Class creatorType = tryForName(creatorClassName, impl);
        return new DefaultInterface(creatorType);
    }

    private String insertNewIntoName(String implName) {
        int lastDot = implName.lastIndexOf(".") + 1;
        String packageName = implName.substring(0, lastDot);
        String className = implName.substring(lastDot, implName.length());
        return packageName + "New" + className;
    }

    private Class tryForName(String creatorClassName, Class impl) {
        try {
            return edgeClass.forName(creatorClassName);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) {
                throw new NoCreatorInterfaceException(creatorClassName, impl);
            }
            throw e;
        }
    }

    private Method tryGetMethod(Interface creator, Class impl, Class[] parameters) {
        try {
            Class clsName = creator.getType();
            return edgeClass.getMethod(clsName, "create", parameters);
        } catch (EdgeException e) {
            if (e.causeIs(NoSuchMethodException.class)) {
                throw new NonMatchingCreatorException(creator, impl);
            }
            throw e;
        }
    }

    private Class[] getConstructorParameters(Class impl) {
        Constructor constructor = reflectMaster.getConstructor(impl);
        return constructor.getParameterTypes();
    }
}
