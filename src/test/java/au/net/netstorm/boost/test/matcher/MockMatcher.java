package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

public final class MockMatcher implements Matcher {
    private final Matcher injectable = new InjectableMatcher();

    public boolean matches(BoostField field) {
        if (!injectable.matches(field)) return false;
        if (!field.isInterface()) return false;
        return isMock(field);
    }

    private boolean isMock(BoostField field) {
        String name = field.getName();
        return name.endsWith("Mock");
    }
}
