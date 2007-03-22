package au.net.netstorm.boost.test.field;

import java.util.ArrayList;
import java.util.List;

public final class DefaultFieldSelector implements FieldSelector {
    public BoostField[] select(BoostField[] fields, Matcher matcher) {
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            BoostField field = fields[i];
            if (matcher.matches(field)) result.add(field);
        }
        return (BoostField[]) result.toArray(new BoostField[]{});
    }
}
