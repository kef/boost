package au.net.netstorm.boost.retire.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import junit.framework.Assert;

// DEBT JavaNCSS {
public final class DefaultParameterCheckerTestUtil implements ParameterCheckerTestUtil {
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();
    private final AssertException assertException = new DefaultAssertException();
    private final ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private final NullMaster nullMaster = new DefaultNullMaster();
    private ThrowableMaster thrower = new DefaultThrowableMaster();
    private final InstanceProvider instanceProvider;
    private ClassMaster classer = new DefaultClassMaster();

    public DefaultParameterCheckerTestUtil(InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider);
        this.instanceProvider = instanceProvider;
    }

    public void checkConstructorsRejectsNull(Class classToCheck) {
        nullMaster.check(classToCheck);
        Constructor[] constructors = classToCheck.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            checkConstructorRejectsNull(constructors[i]);
        }
    }

    public void checkConstructorsRejectEmptyString(Class classToCheck) {
        nullMaster.check(classToCheck);
        Constructor[] constructors = classToCheck.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            checkConstructorRejectsEmptyString(constructors[i]);
        }
    }

    public void checkMethodsRejectsNull(Object instance) {
        nullMaster.check(instance);
        List methods = getPublicMethods(instance.getClass());
        for (Iterator iterator = methods.iterator(); iterator.hasNext();) {
            checkMethodRejectsNull(instance, (Method) iterator.next());
        }
    }

    public void checkMethodsRejectEmptyString(Object instance) {
        nullMaster.check(instance);
        List methods = getPublicMethods(instance.getClass());
        for (Iterator iterator = methods.iterator(); iterator.hasNext();) {
            checkMethodsRejectsEmptyString(instance, (Method) iterator.next());
        }
    }

    private void checkMethodsRejectsEmptyString(Object instance, Method method) {
        Class[] paramTypes = method.getParameterTypes();
        for (int paramToCheck = 0; paramToCheck < paramTypes.length; paramToCheck++) {
            emptyStringCheckParameters(instance, method, paramTypes, paramToCheck);
        }
    }

    private void checkMethodRejectsNull(Object instance, Method method) {
        Class[] paramTypes = method.getParameterTypes();
        for (int paramToCheck = 0; paramToCheck < paramTypes.length; paramToCheck++) {
            checkParameter(instance, method, paramTypes, paramToCheck, null, "null");
        }
    }

    private void emptyStringCheckParameters(Object instance, Method method, Class[] paramTypes, int paramToCheck) {
        if (isAString(paramTypes[paramToCheck])) {
            checkParameter(instance, method, paramTypes, paramToCheck, "", "empty string");
            checkParameter(instance, method, paramTypes, paramToCheck, " ", "empty string");
        }
    }

    private List getPublicMethods(Class cls) {
        List publicMethods = new ArrayList();
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (modifierUtil.isPublic(methods[i])) {
                publicMethods.add(methods[i]);
            }
        }
        return publicMethods;
    }

    private void checkConstructorRejectsNull(Constructor constructor) {
        Class[] paramTypes = constructor.getParameterTypes();
        for (int paramToCheck = 0; paramToCheck < paramTypes.length; paramToCheck++) {
            checkParameter(constructor, paramTypes, paramToCheck, null, "null");
        }
    }

    private void checkConstructorRejectsEmptyString(Constructor constructor) {
        Class[] paramTypes = constructor.getParameterTypes();
        for (int paramToCheck = 0; paramToCheck < paramTypes.length; paramToCheck++) {
            emptyStringCheckParameters(constructor, paramTypes, paramToCheck);
        }
    }

    private void emptyStringCheckParameters(Constructor constructor, Class[] paramTypes, int paramToCheck) {
        if (isAString(paramTypes[paramToCheck])) {
            checkParameter(constructor, paramTypes, paramToCheck, "", "empty string");
            checkParameter(constructor, paramTypes, paramToCheck, " ", "empty string");
        }
    }

    // DEBT ParameterNumber {
    private void checkParameter(Constructor constructor, Class[] paramTypes, int paramToCheck,
            String badParamValue, String badParamTypeName) {
        Object[] parameterValues = createBadParamValues(instanceProvider, paramTypes, paramToCheck, badParamValue);
        checkFailsWithInvalidValues(constructor, paramToCheck, parameterValues, badParamTypeName);
    }
    // } DEBT ParameterNumber

    // DEBT ParameterNumber {

    private void checkParameter(Object instance, Method method, Class[] paramTypes, int paramToCheck,
            String badParamValue, String badParamTypeName) {
        Object[] parameterValues = createBadParamValues(instanceProvider, paramTypes, paramToCheck, badParamValue);
        checkFailsWithInvalidValues(instance, method, paramToCheck, parameterValues, badParamTypeName);
    }
    // } DEBT ParameterNumber

    private Object[] createBadParamValues(InstanceProvider instanceProvider, Class[] paramTypes,
            int indexOfParamToMakeBad, Object badValue) {
        Object[] paramValues = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            paramValues[i] = instanceProvider.newInstance(paramTypes[i]);
        }
        setBadParam(paramValues, paramTypes, indexOfParamToMakeBad, badValue);
        return paramValues;
    }

    private void handleException(EdgeException e) {
        Throwable real = thrower.realCause(e);
        thrower.rethrow(real);
    }

    private void checkFailsWithInvalidValues(Constructor constructor, int currentParameter, Object[] paramValues,
            String badParamTypeName) {
        try {
            invoke(constructor, paramValues);
            failConstructor(currentParameter, constructor, badParamTypeName);
        } catch (Exception e) {
            assertException.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }

    // DEBT ParameterNumber {
    private void checkFailsWithInvalidValues(Object instance, Method method, int currentParameter,
            Object[] parameterValues, String badParamTypeName) {
        try {
            invoke(instance, method, parameterValues);
            failMethod(currentParameter, method, badParamTypeName);
        } catch (Exception e) {
            assertException.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }
    // } DEBT ParameterNumber

    private boolean isAString(Class type) {
        return String.class.isAssignableFrom(type);
    }

    private void invoke(Object instance, Method method, Object[] paramValues) {
        method.setAccessible(true);
        try {
            edgeMethod.invoke(method, instance, paramValues);
        } catch (EdgeException e) {
            handleException(e);
        }
    }

    private void invoke(Constructor constructor, Object[] paramValues) {
        constructor.setAccessible(true);
        try {
            edgeConstructor.newInstance(constructor, paramValues);
        } catch (EdgeException e) {
            handleException(e);
        }
    }

    private void failMethod(int currentParameter, Method method, String badParamTypeName) {
        Class[] parameterTypes = method.getParameterTypes();
        String declaringClassName = shortName(method);
        String paramTypeClassName = shortName(parameterTypes[currentParameter]);
        String methodName = declaringClassName + "." + method.getName();
        fail(currentParameter, methodName, paramTypeClassName, badParamTypeName);
    }

    private String shortName(Method method) {
        Class declaringClass = method.getDeclaringClass();
        return shortName(declaringClass);
    }

    private String shortName(Class aClass) {
        return classer.getShortName(aClass);
    }

    private void failConstructor(int currentParameter, Constructor constructor, String badParamTypeName) {
        Class[] parameterTypes = constructor.getParameterTypes();
        String paramTypeClassName = shortName(parameterTypes[currentParameter]);
        String methodName = shortName(constructor.getDeclaringClass());
        fail(currentParameter, methodName, paramTypeClassName, badParamTypeName);
    }

    private void fail(int currentParameter, String methodName, String paramTypeClassName, String badParamTypeName) {
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName
                + "...) must be " + badParamTypeName + " checked";
        Assert.fail(message);
    }

    private void setBadParam(Object[] paramValues, Class[] paramTypes, int indexOfParamToMakeBad, Object badValue) {
        if (badValue == null) {
            paramValues[indexOfParamToMakeBad] = badValue;
        } else if (badValue.getClass().isAssignableFrom(paramTypes[indexOfParamToMakeBad])) {
            paramValues[indexOfParamToMakeBad] = badValue;
        } else {
            throw new RuntimeException("Expected value '" + badValue + "' to be of type " +
                    shortName(paramTypes[indexOfParamToMakeBad]));
        }
    }
}
// } DEBT JavaNCSS
