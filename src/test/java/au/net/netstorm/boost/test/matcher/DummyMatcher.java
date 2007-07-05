package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

public final class DummyMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        if (isDummy(field)) return true;
        if (field.isInterface()) return false;
        return !field.isArray();
    }

    private boolean isDummy(BoostField field) {
        return field.isInterface() && isDummyField(field);
    }

    private boolean isDummyField(BoostField field) {
        return field.getName().endsWith("Dummy");
    }
}
