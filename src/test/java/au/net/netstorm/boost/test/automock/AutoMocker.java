package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.field.BoostField;
import org.jmock.Mock;

public interface AutoMocker {
    Mock get(Object proxy);

    Object mock(Class type);

    void mock(BoostField[] fields, LifecycleTestCase testCase);
}
