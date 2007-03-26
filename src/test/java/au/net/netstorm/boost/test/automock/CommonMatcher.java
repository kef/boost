package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

// OK NCSS|CyclomaticComplexity|ReturnCount {
public final class CommonMatcher implements Matcher {
    public boolean matches(BoostField field) {
        if (field.isStatic()) return false;
        if (field.isFinal()) return false;
        if (field.isPrimitive()) return false;
        if (field.prefix("subject")) return false;
        if (field.is("expect")) return false;
        return field.isNull();
    }
}
// } OK NCSS|CyclomaticComplexity|ReturnCount
