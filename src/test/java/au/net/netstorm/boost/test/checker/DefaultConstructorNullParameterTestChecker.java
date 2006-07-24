package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.instance.InstanceProvider;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import junit.framework.Assert;

public final class DefaultConstructorNullParameterTestChecker implements ConstructorNullParameterTestChecker {
    private static final DefaultNullMaster NULL_MASTER = new DefaultNullMaster();
    private static final DefaultClassMaster CLASS_MASTER = new DefaultClassMaster();
    private final InstanceProvider instanceProvider;

    public DefaultConstructorNullParameterTestChecker(InstanceProvider instanceProvider) {
        NULL_MASTER.check(instanceProvider, "instanceProvider");
        this.instanceProvider = instanceProvider;
    }

    public void checkPublicConstructorsRejectNull(Class classToCheck) {
        NULL_MASTER.check(classToCheck, "classToCheck");
        Constructor[] constructors = classToCheck.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            checkConstructorRejectsNull(constructors[i]);
        }
    }

    public void checkConstructorRejectsNull(Constructor constructor) {
        NULL_MASTER.check(constructor, "constructor");
        Class[] paramTypes = constructor.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckConstructor(constructor, i, paramTypes);
        }
    }

    // FIXME: SC523 This needs a refactor.
    private void nullCheckConstructor(final Constructor constructor, int currentParameter, Class[] paramTypes) {
        final Object[] paramValues = ParameterTestUtil.createParameterValuesWithNull(instanceProvider, paramTypes, currentParameter);
        try {
            invoke(constructor, paramValues);
            fail(paramTypes, currentParameter, constructor);
        } catch (Exception e) {
            ParameterTestUtil.checkExceptionIsIllegalArgumentException(e);
        }
    }

    private void invoke(final Constructor constructor, final Object[] paramValues) {
        constructor.setAccessible(true);
        Call invokeBlock = new Call() {
            public void execute() {
                EdgeConstructor.EDGE_CONSTRUCTOR.newInstance(constructor, paramValues);
            }
        };
        ParameterTestUtil.invokeBlock(invokeBlock);
    }

    private void fail(Class[] paramTypes, int currentParameter, Constructor constructor) {
        String paramTypeClassName = CLASS_MASTER.getShortName(paramTypes[currentParameter]);
        String methodName = CLASS_MASTER.getShortName(constructor.getDeclaringClass());
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }
}
