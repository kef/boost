package au.net.netstorm.boost.nursery.pebble;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.DefaultInterface;

// FIX 1665 Move out of nursery.

// FIX 1665 Move to test tree.
public final class DefaultPebbleChecker implements PebbleChecker {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class impl) {
        Interface creator = getCreator(impl);
        Class[] parameters = getConstructorParameters(impl);
        tryGetMethod(creator, impl, parameters);
    }

    private Interface getCreator(Class impl) {
        String creatorClassName = impl.getName() + "Creator";
        Class creatorType = tryForName(creatorClassName, impl);
        return new DefaultInterface(creatorType);
    }

    private Class tryForName(String creatorClassName, Class impl) {
        try {
            return edgeClass.forName(creatorClassName);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) {
                throw new NoNewerInterfaceException(creatorClassName, impl);
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
