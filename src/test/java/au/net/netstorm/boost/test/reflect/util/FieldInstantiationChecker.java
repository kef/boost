package au.net.netstorm.boost.test.reflect.util;

public interface FieldInstantiationChecker {
    void check(Object ref, String fieldName, Class expectedImplClass);
}
