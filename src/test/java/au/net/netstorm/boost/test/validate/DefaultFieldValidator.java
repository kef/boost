package au.net.netstorm.boost.test.validate;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;

// OK CyclomaticComplexity|NCSS {
public final class DefaultFieldValidator implements Validator {
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();

    public void validate(Object ref) {
        BoostField[] fields = fieldBuilder.build(ref);
        validateFields(fields);
    }

    private void validateFields(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            validateField(fields[i]);
        }
    }

    private void validateField(BoostField field) {
        if (field.isSynthetic()) return;
        if (isStatic(field)) staticChecks(field);
        else instanceChecks(field);
    }

    private void instanceChecks(BoostField field) {
        // FIX 1676 bangPrimitives if array.getComponentType() is a primitive.
        if (field.isPrimitive()) bangPrimitives(field);
        if (field.isPublic()) troglodyte(field);
        if (field.isProtected()) troglodyte(field);
        if (field.isFinal()) bangFinals(field);
    }

    private void staticChecks(BoostField field) {
        if (!field.isFinal()) kaboom("Your static must be final!", field);
    }

    private boolean isStatic(BoostField field) {
        return field.isStatic();
    }

    private void bangPrimitives(BoostField field) {
        kaboom("Rooster head ... no primitives in tests.", field);
    }

    private void bangFinals(BoostField field) {
        kaboom("We don't do final and neither should you ;)  Either a field is set (non-null) or it is auto-injected.", field);
    }

    private void troglodyte(BoostField field) {
        kaboom("Troglodyte ... make me package private or private.", field);
    }

    private void kaboom(String s, BoostField field) {
        String name = field.getName();
        throw new ValidationException(s + " : " + name);
    }
}
// } OK CyclomaticComplexity|NCSS
