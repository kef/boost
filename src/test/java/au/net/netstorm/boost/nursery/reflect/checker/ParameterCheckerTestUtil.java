package au.net.netstorm.boost.nursery.reflect.checker;

public interface ParameterCheckerTestUtil {
    void checkConstructorsRejectsNull(Class classToCheck);

    void checkConstructorsRejectEmptyString(Class classToCheck);

    void checkMethodsRejectsNull(Object instance);

    void checkMethodsRejectEmptyString(Object instance);
}
