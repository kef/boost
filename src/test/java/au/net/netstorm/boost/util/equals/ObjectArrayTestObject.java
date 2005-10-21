package au.net.netstorm.boost.util.equals;

import java.util.Arrays;

public class ObjectArrayTestObject {
    private Object[] buffer;

    public ObjectArrayTestObject(Object[] buffer) {
        this.buffer = buffer;
    }

    public String toString() {
        return "For Checkstyle ArrayTestObject[aBuffer=" + Arrays.asList(buffer) + "]";
    }
}
