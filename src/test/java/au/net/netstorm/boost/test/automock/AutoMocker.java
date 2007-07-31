package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;

public interface AutoMocker {
    Object mock(Class type);

    void mock(BoostField[] fields);

    void dummy(BoostField[] fields);
}
