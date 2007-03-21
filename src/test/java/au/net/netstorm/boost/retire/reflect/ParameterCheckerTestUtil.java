package au.net.netstorm.boost.retire.reflect;

public interface ParameterCheckerTestUtil {
    void checkConstructorsRejectsNull(Class classToCheck);

    void checkConstructorsRejectEmptyString(Class classToCheck);

    void checkMethodsRejectsNull(Object instance);

    void checkMethodsRejectEmptyString(Object instance);
}
