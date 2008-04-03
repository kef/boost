package au.net.netstorm.boost.gunge.reflect.util;

public interface FieldInstantiationChecker {
    void check(Object ref, String fieldName, Class expectedImplClass);
}
