package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

// FIX 2076 CARD Make all Data objects dummies - get rid of this.
public final class MockMatcher implements Matcher {
    private final Matcher common = new InjectableMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isInterface() && !isDummy(field);
    }

    private boolean isDummy(BoostField field) {
        String name = field.getName();
        return name.endsWith("Dummy");
    }
}
