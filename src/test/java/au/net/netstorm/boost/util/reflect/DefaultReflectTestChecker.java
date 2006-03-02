package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 Complete this.

public final class DefaultReflectTestChecker implements ReflectTestChecker {
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final FieldTestChecker fieldChecker = new DefaultFieldTestChecker();
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();

    public void checkImplementsAndFinal(Class targetInterface, Class implementationClass) {
        clsChecker.checkImplementsAndFinal(targetInterface, implementationClass);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        clsChecker.checkSubclassOf(superClass, subClass);
    }

    public void checkSubclassOf(Class expectedImpl, Object ref) {
        clsChecker.checkSubclassOf(expectedImpl, ref);
    }

    // FIXME: SC042 Move this up in order.
    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        clsChecker.checkImplementsAndFinal(expectedInterface, cls);
    }

    public void checkSynchronized(Class cls) {
        clsChecker.checkSynchronized(cls);
    }

    public void checkPrivateFinalField(Class type, String fieldName) {
        fieldChecker.checkPrivateFinalField(type, fieldName);
    }

    public void checkType(Class expectedClass, Object ref, String fieldName) {
        fieldChecker.checkType(expectedClass, ref, fieldName);
    }

    public void checkFinal(Method method) {
        modifierChecker.checkFinal(method);
    }

    public void checkSynchronized(Method method) {
        modifierChecker.checkSynchronized(method);
    }

    public void checkPublic(Class cls) {
        modifierChecker.checkPublic(cls);
    }

    public void checkFinal(Class cls) {
        modifierChecker.checkFinal(cls);
    }

    public void checkConcrete(Class cls) {
        modifierChecker.checkConcrete(cls);
    }
}
