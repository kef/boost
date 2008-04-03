package au.net.netstorm.boost.gunge.validate;

public final class DefaultTestClassValidator implements TestClassValidator {
    private final InterfaceMethodValidator interfaceMethodValidator = new DefaultInterfaceMethodValidator();
    private final Validator fieldValidator = new DefaultFieldValidator();

    public void validate(Object ref) {
        TestMethodMatcher methodMatcher = new TestMethodMatcher();
        interfaceMethodValidator.validate(ref, methodMatcher);
        fieldValidator.validate(ref);
    }
}
