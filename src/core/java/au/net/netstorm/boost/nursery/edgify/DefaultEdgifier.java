package au.net.netstorm.boost.nursery.edgify;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;

public final class DefaultEdgifier implements Edgifier {
    private static final Class[] NO_ARGS = {};
    private final EdgifierHorizon edgifierHorizon = new DefaultEdgifierHorizon();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final EdgeClass edgeClasser = new DefaultEdgeClass();
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();

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