package au.net.netstorm.boost.util.tostring;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public final class MockToStringMaster implements ToStringMaster {
    private String result;
    private Object ref;

    public void prepare(String result) {
        this.result = result;
    }

    public String getString(Object ref) {
        this.ref = ref;
        return result;
    }

    public String formatFields(Object ref, FieldValueSpec[] fields) {
        this.ref = ref;
        return result;
    }

    public Object getRef() {
        return ref;
    }
}
