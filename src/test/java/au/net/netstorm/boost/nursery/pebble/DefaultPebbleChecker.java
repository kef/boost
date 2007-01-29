package au.net.netstorm.boost.nursery.pebble;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;

// FIX 1665 Move out of nursery.

// FIX 1665 Move to test tree.
public final class DefaultPebbleChecker implements PebbleChecker {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class impl) {
        String newer = impl.getName() + "_";
        Class creator = tryForName(newer, impl);
        Class[] parameters = getConstructorParameters(impl);
        tryGetMethod(creator, impl, parameters);
    }

    private Class tryForName(String newer, Class impl) {
        try {
            return edgeClass.forName(newer);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) {
                throw new NoNewerInterfaceException(newer, impl);
            }
            throw e;
        }
    }

    private Method tryGetMethod(Class creator, Class impl, Class[] parameters) {
        try {
            return edgeClass.getMethod(creator, "_", parameters);
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
