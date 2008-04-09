package au.net.netstorm.boost.sniper.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.sniper.matcher.Matcher;
import au.net.netstorm.boost.sniper.matcher.TestFieldMatcher;

public final class TestFieldSelector implements FieldSelector {
    private final Matcher testMatcher = new TestFieldMatcher();

    public BoostField[] select(BoostField[] fields, Matcher matcher) {
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            select(fields[i], matcher, result);
        }
        return (BoostField[]) result.toArray(new BoostField[]{});
    }

    private void select(BoostField field, Matcher matcher, List result) {
        if (!testMatcher.matches(field)) return;
        if (matcher.matches(field)) result.add(field);
    }
}
