package au.net.netstorm.boost.gunge.automock;

import au.net.netstorm.boost.gunge.field.BoostField;

public interface AutoMocker {
    Object mock(Class type);

    void mock(BoostField[] fields);

    void dummy(BoostField[] fields);
}
