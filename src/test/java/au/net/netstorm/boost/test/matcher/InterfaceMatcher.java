package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

// OK CyclomaticComplexity|ReturnCount {

// FIX 2076 Get rid of this as part of card to make all Data objects dummies
public final class InterfaceMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isInterface() && !isDummy(field);
    }

    private boolean isDummy(BoostField field) {
        String name = field.getName();
        return name.endsWith("Dummy");
    }
}
// } OK CyclomaticComplexity|ReturnCount
