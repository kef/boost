package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

public final class DummyMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        if (isDummy(field)) return true;
        return false;
    }

    private boolean isDummy(BoostField field) {
        return isDummyField(field);
    }

    private boolean isDummyField(BoostField field) {
        // FIX 2076 Make a card for this.
        //return Data.class.isAssignableFrom(field.getType());
        String name = field.getName();
        return name.endsWith("Dummy");
    }
}
