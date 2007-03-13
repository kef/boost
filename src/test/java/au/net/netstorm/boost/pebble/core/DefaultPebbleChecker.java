package au.net.netstorm.boost.pebble.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.type.NoNewerInterfaceException;
import au.net.netstorm.boost.pebble.type.NonMatchingNewerException;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleChecker implements PebbleChecker {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class impl) {
        Interface newer = getNewer(impl);
        Class[] parameters = getConstructorParameters(impl);
        tryGetMethod(newer, impl, parameters);
    }

    private Interface getNewer(Class impl) {
        String newerClassName = insertNewIntoName(impl.getName());
        Class newerType = tryForName(newerClassName, impl);
        return new DefaultInterface(newerType);
    }

    private String insertNewIntoName(String implName) {
        int lastDot = implName.lastIndexOf(".") + 1;
        String packageName = implName.substring(0, lastDot);
        String className = implName.substring(lastDot, implName.length());
        return packageName + "New" + className;
    }

    private Class tryForName(String newerClassName, Class impl) {
        try {
            return edgeClass.forName(newerClassName);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) {
                throw new NoNewerInterfaceException(newerClassName, impl);
            }
            throw e;
        }
    }

    private Method tryGetMethod(Interface newer, Class impl, Class[] parameters) {
        try {
            Class clsName = newer.getType();
            return edgeClass.getMethod(clsName, "nu", parameters);
        } catch (EdgeException e) {
            if (e.causeIs(NoSuchMethodException.class)) {
                throw new NonMatchingNewerException(newer, impl);
            }
            throw e;
        }
    }

    private Class[] getConstructorParameters(Class impl) {
        Constructor constructor = reflectMaster.getConstructor(impl);
        return constructor.getParameterTypes();
    }
}
