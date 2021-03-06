package au.net.netstorm.boost.nursery.edgify;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeMethod;

public final class DefaultEdgifier implements Edgifier {
    private static final Class[] NO_ARGS = {};
    private final EdgifierHorizon edgifierHorizon;
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final EdgeClass edgeClasser = new DefaultEdgeClass();
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();

    public DefaultEdgifier(String prefix) {
        edgifierHorizon = new DefaultEdgifierHorizon(prefix);
    }

    // SUGGEST Is passing in the class here is redundant???
    public Object edgify(Object real, Class realClass) {
        if (real == null) return null;
        Class edgeClass = edgifierHorizon.toEdge(realClass);
        Constructor constructor = reflector.getConstructor(edgeClass);
        constructor.setAccessible(true);
        Object[] parameters = {real};
        return edgeConstructor.newInstance(constructor, parameters);
    }

    public Object[] edgify(Object[] real, Class realClass) {
        if (real == null) return null;
        Class edgeClass = edgifierHorizon.toEdge(realClass);
        Object[] result = newArray(real, edgeClass);
        for (int i = 0; i < real.length; i++) {
            result[i] = edgify(real[i], realClass);
        }
        return result;
    }

    public Object deEdgify(Object edge, Class edgeClass) {
        Method method = edgeClasser.getMethod(edgeClass, "deEdgify", NO_ARGS);
        return edgeMethod.invoke(method, edge, NO_ARGS);
    }

    public Object[] deEdgify(Object[] edge, Class edgeClass) {
        if (edge == null) return null;
        Class realClass = edgifierHorizon.toReal(edgeClass);
        Object[] result = newArray(edge, realClass);
        for (int i = 0; i < edge.length; i++) {
            result[i] = deEdgify(edge[i], edgeClass);
        }
        return result;
    }

    private Object[] newArray(Object[] real, Class edgeClass) {
        int length = real.length;
        return (Object[]) Array.newInstance(edgeClass, length);
    }
}