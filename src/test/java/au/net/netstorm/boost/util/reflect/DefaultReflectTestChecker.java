package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;

import au.net.netstorm.boost.util.type.Interface;

public final class DefaultReflectTestChecker implements ReflectTestChecker {
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final FieldTestChecker fieldChecker = new DefaultFieldTestChecker();
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        clsChecker.checkImplementsAndFinal(expectedInterface, cls);
    }

    public void checkImplementsAndFinal(Class targetInterface, Class implementationClass) {
        clsChecker.checkImplementsAndFinal(targetInterface, implementationClass);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        clsChecker.checkSubclassOf(superClass, subClass);
    }

    public void checkSubclassOf(Class expectedImpl, Object ref) {
        clsChecker.checkSubclassOf(expectedImpl, ref);
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

    public void checkFinal(Member member) {
        modifierChecker.checkFinal(member);
    }

    public void checkSynchronized(Member member) {
        modifierChecker.checkSynchronized(member);
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
