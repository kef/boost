package au.net.netstorm.boost.sniper.validate;

public interface InterfaceMethodValidator extends Validator {
    void validate(Object ref, MethodMatcher[] allowed);

    void validate(Object ref, MethodMatcher allowed);
}
