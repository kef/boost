package au.net.netstorm.boost.test.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.matcher.Matcher;

public final class TestFieldSelector implements FieldSelector {
    public BoostField[] select(BoostField[] fields, Matcher matcher) {
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            BoostField field = fields[i];
            select(field, matcher, result);
        }
        return (BoostField[]) result.toArray(new BoostField[]{});
    }

    private void select(BoostField field, Matcher matcher, List result) {
        if (!field.isNull()) return;
        if (matcher.matches(field)) result.add(field);
    }
}
