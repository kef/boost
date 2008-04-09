package au.net.netstorm.boost.sniper.reflect.util;

public interface FieldInstantiationChecker {
    void check(Object ref, String fieldName, Class expectedImplClass);
}
