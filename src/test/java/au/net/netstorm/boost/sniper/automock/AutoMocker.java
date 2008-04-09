package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.sniper.field.BoostField;

public interface AutoMocker {
    Object mock(Class type);

    void mock(BoostField[] fields);

    void dummy(BoostField[] fields);
}
