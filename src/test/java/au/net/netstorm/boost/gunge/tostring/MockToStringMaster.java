package au.net.netstorm.boost.gunge.tostring;

import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;

public final class MockToStringMaster implements ToStringMaster {
    private String result;
    private Object ref;

    public void prepare(String result) {
        this.result = result;
    }

    public String string(Object ref) {
        this.ref = ref;
        return result;
    }

    public String string(Object ref, FieldValueSpec[] fields) {
        this.ref = ref;
        return result;
    }

    public Object getRef() {
        return ref;
    }
}
