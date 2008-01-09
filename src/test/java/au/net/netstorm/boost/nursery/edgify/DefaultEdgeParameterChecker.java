package au.net.netstorm.boost.nursery.edgify;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import junit.framework.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DefaultEdgeParameterChecker implements EdgeChecker {
    private static final String EDGE = "Edge";
    private final List validNonEdges = new ArrayList();
    private final List parameterCheckExceptions = new ArrayList();
    private final ModifierTestUtil modifierTestUtil = new DefaultModifierTestUtil();
    private final ClassMaster classMaster = new DefaultClassMaster();

    {
        parameterCheckExceptions.add(DefaultEdgifierHorizon.class);
        validNonEdges.add(String.class);
        validNonEdges.add(Object.class);
        validNonEdges.add(Map.class);
    }

    public void check(Class edgeClass) {
        if (parameterCheckExceptions.contains(edgeClass)) return;
        checkMethods(edgeClass);
    }

    private void checkMethods(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            checkParameters(cls, methods[i]);
        }
    }

    private void checkParameters(Class cls, Method method) {
        if (!modifierTestUtil.isPublic(method)) return;
        Class[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterClass = getClassType(parameterTypes[i]);
            checkParameter(parameterClass, method, cls);
        }
    }

    private void checkParameter(Class parameterClass, Method method, Class edgeClass) {
        if (isValidNonEdge(parameterClass)) return;
        checkParameterIsEdge(parameterClass, edgeClass, method);
    }

    private void checkParameterIsEdge(Class parameterCls, Class edgeClass, Method method) {
        String parameterShortName = classMaster.getShortName(parameterCls);
        if (parameterShortName.startsWith(EDGE)) return;
        String methodName = method.getName();
        Assert.fail(parameterShortName + " should be passed in as an Edge in method " + methodName + " of " + edgeClass);
    }

    private Class getClassType(Class cls) {
        if (cls.isArray()) return cls.getComponentType();
        return cls;
    }

    private boolean isValidNonEdge(Class cls) {
        return validNonEdges.contains(cls) || cls.isPrimitive();
    }
}
