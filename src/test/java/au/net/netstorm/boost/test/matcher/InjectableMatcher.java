package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

// OK NCSS|CyclomaticComplexity|ReturnCount {
public final class InjectableMatcher implements Matcher {
    public boolean matches(BoostField field) {
        if (field.isPrivate()) return false;
        if (field.isStatic()) return false;
        if (field.isFinal()) return false;
        if (field.prefix("subject")) return false;
        if (field.is("expect")) return false;
        return true;
    }
}
// } OK NCSS|CyclomaticComplexity|ReturnCount
