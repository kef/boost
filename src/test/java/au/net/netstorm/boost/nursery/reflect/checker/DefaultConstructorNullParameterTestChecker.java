package au.net.netstorm.boost.nursery.reflect.checker;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import junit.framework.Assert;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultConstructorNullParameterTestChecker implements ConstructorNullParameterTestChecker {
    private final NullMaster nullMaster = new DefaultNullMaster();
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final AssertException assertException = new DefaultAssertException();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final ParameterTestUtil parameterUtil = new DefaultParameterTestUtil();
    private final InstanceProvider instanceProvider;

    public DefaultConstructorNullParameterTestChecker(InstanceProvider instanceProvider) {
        nullMaster.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicConstructorsRejectNull(Class classToCheck) {
        nullMaster.check(classToCheck, "classToCheck");
        Constructor[] constructors = classToCheck.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            checkConstructorRejectsNull(constructors[i]);
        }
    }

    private void checkConstructorRejectsNull(Constructor constructor) {
        Class[] paramTypes = constructor.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckConstructor(constructor, i, paramTypes);
        }
    }

    // SUGGEST This needs a refactor.
    private void nullCheckConstructor(Constructor constructor, int currentParameter, Class[] paramTypes) {
        Object[] paramValues = parameterUtil.createBadParamValues(instanceProvider, paramTypes, currentParameter, null);
        try {
            invoke(constructor, paramValues);
            fail(paramTypes, currentParameter, constructor);
        } catch (Exception e) {
            assertException.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }

    // SUGGEST We need ability to turn accessibility on/off in just one place.
    private void invoke(Constructor constructor, Object[] paramValues) {
        constructor.setAccessible(true);
        try {
            edgeConstructor.newInstance(constructor, paramValues);
        } catch (EdgeException e) {
            parameterUtil.handleException(e);
        }
    }

    private void fail(Class[] paramTypes, int currentParameter, Constructor constructor) {
        String paramTypeClassName = classMaster.getShortName(paramTypes[currentParameter]);
        String methodName = classMaster.getShortName(constructor.getDeclaringClass());
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }
}
// } DEBT ClassDataAbstractionCoupling
