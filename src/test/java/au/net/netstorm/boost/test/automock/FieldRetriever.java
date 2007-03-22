package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;

public interface FieldRetriever {
    BoostField[] retrieve(Object ref);
}
