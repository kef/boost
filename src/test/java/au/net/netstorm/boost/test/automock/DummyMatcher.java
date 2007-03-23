package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class DummyMatcher implements Matcher {

    // OK CyclomaticComplexity|ReturnCount {
    public boolean matches(BoostField field) {
        if (field.isInterface()) return false;
        if (field.isPrimitive()) return false;
        if (field.isFinal()) return false;
        if (field.isStatic()) return false;
        return field.isNull();
    }
    // } OK CyclomaticComplexity|ReturnCount
}
