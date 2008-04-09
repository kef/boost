package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.sniper.field.BoostField;

public class DefaultAutoMocker implements AutoMocker {
    private final MockSupport mockSupport;

    public DefaultAutoMocker(MockSupport mockSupport) {
        this.mockSupport = mockSupport;
    }

    public Object mock(Class type) {
        return mockSupport.mock(type);
    }

    public void mock(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            mock(fields[i]);
        }
    }

    public void dummy(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            dummy(fields[i]);
        }
    }

    private void mock(BoostField field) {
        Class type = field.getType();
        String name = field.getName();
        Object object = mockSupport.mock(type, name);
        field.set(object);
    }

    private void dummy(BoostField field) {
        Class type = field.getType();
        String name = field.getName();
        Object dummy = mockSupport.dummy(type, name);
        field.set(dummy);
    }
}
