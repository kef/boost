package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

// OK CyclomaticComplexity|ReturnCount {
public final class InterfaceMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isInterface();
    }
}
// } OK CyclomaticComplexity|ReturnCount
