package au.net.netstorm.boost.gunge.matcher;

import au.net.netstorm.boost.gunge.field.BoostField;

// OK NCSS|CyclomaticComplexity|ReturnCount {
public final class TestFieldMatcher implements Matcher {
    public boolean matches(BoostField field) {
        if (field.isPrivate()) return false;
        if (field.isStatic()) return false;
        if (field.isFinal()) return false;
        if (field.prefix("subject")) return false;
        if (field.is("expect")) return false;
        return field.isNull();
    }
}
// } OK NCSS|CyclomaticComplexity|ReturnCount
