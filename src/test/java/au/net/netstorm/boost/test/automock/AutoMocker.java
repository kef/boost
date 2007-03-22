package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import org.jmock.Mock;

interface AutoMocker {
    Mock get(Object proxy);

    void mock(BoostField[] fields);
}
