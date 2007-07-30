package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.FieldSuffix;
import au.net.netstorm.boost.test.matcher.Matcher;

public final class FieldSuffixMatcher implements Matcher {
    private final FieldSuffix suffix;

    public FieldSuffixMatcher(FieldSuffix suffix) {
        this.suffix = suffix;
    }

    public boolean matches(BoostField field) {
        if (!field.isInterface()) return false;
        Field realField = field.getField();
        return suffix.matches(realField);
    }
}

