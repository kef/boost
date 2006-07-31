package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import junit.framework.Assert;

public final class DefaultConstructorNullParameterTestChecker implements ConstructorNullParameterTestChecker {
    // FIXME: SC600 Use instances whereever possible.
    private static final NullMaster NULL_MASTER = new DefaultNullMaster();
    private static final ClassMaster CLASS_MASTER = new DefaultClassMaster();
    private static final AssertException ASSERT_EXCEPTION = new DefaultAssertException();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final ParameterTestUtil parameterUtil = new DefaultParameterTestUtil();
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

    private void checkConstructorRejectsNull(Constructor constructor) {
        NULL_MASTER.check(constructor, "constructor");
        Class[] paramTypes = constructor.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            nullCheckConstructor(constructor, i, paramTypes);
        }
    }

    // FIXME: SC523 This needs a refactor.
    private void nullCheckConstructor(final Constructor constructor, int currentParameter, Class[] paramTypes) {
        final Object[] paramValues = parameterUtil.createParameterValuesWithNull(instanceProvider, paramTypes, currentParameter);
        try {
            invoke(constructor, paramValues);
            fail(paramTypes, currentParameter, constructor);
        } catch (Exception e) {
            ASSERT_EXCEPTION.checkExceptionClass(IllegalArgumentException.class, e);
        }
    }

    // FIXME: SC043 We need ability to turn accessibility on/off in just one place.
    private void invoke(final Constructor constructor, final Object[] paramValues) {
        constructor.setAccessible(true);
        Call invokeBlock = new Call() {
            public void execute() {
                edgeConstructor.newInstance(constructor, paramValues);
            }
        };
        parameterUtil.invokeBlock(invokeBlock);
    }

    private void fail(Class[] paramTypes, int currentParameter, Constructor constructor) {
        String paramTypeClassName = CLASS_MASTER.getShortName(paramTypes[currentParameter]);
        String methodName = CLASS_MASTER.getShortName(constructor.getDeclaringClass());
        String message = "Argument " + (currentParameter + 1) + " of " + methodName + "(..." + paramTypeClassName + "...) must be null checked";
        Assert.fail(message);
    }
}
