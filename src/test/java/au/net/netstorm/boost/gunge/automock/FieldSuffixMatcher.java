package au.net.netstorm.boost.gunge.automock;

import java.lang.reflect.Field;
import au.net.netstorm.boost.gunge.field.BoostField;
import au.net.netstorm.boost.gunge.field.FieldSuffix;
import au.net.netstorm.boost.gunge.matcher.Matcher;

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

