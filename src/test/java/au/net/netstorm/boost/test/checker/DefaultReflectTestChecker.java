package au.net.netstorm.boost.test.checker;

import java.lang.reflect.Member;

import au.net.netstorm.boost.util.type.Interface;

// FIX SC521 This should totally go.  Replaced by a single line (maybe 5).

public final class DefaultReflectTestChecker implements ReflectTestChecker {
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final FieldTestChecker fieldChecker = new DefaultFieldTestChecker();
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        clsChecker.checkImplementsAndFinal(expectedInterface, cls);
    }

    public void checkImplementsAndFinal(Class implementationClass, Class targetInterface) {
        clsChecker.checkImplementsAndFinal(implementationClass, targetInterface);
    }

    public void checkSubInterfaceOf(Interface superInterface, Interface subInterface) {
        clsChecker.checkSubInterfaceOf(superInterface, subInterface);
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

    public void checkPrivateFinalInstanceField(Class type, String fieldName) {
        fieldChecker.checkPrivateFinalInstanceField(type, fieldName);
    }

    public void checkInstanceType(Class expectedClass, Object ref, String fieldName) {
        fieldChecker.checkInstanceType(expectedClass, ref, fieldName);
    }

    public void checkPublic(Member member) {
        modifierChecker.checkPublic(member);
    }

    public void checkPrivate(Member member) {
        modifierChecker.checkPrivate(member);
    }

    public void checkFinal(Member member) {
        modifierChecker.checkFinal(member);
    }

    public void checkSynchronized(Member member) {
        modifierChecker.checkSynchronized(member);
    }

    public void checkStatic(Member member) {
        modifierChecker.checkStatic(member);
    }

    public void checkInstance(Member member) {
        modifierChecker.checkInstance(member);
    }

    public void checkPrivateFinalInstance(Member member) {
        modifierChecker.checkPrivateFinalInstance(member);
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
