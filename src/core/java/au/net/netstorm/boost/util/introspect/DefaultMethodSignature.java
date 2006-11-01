package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 525 Extract interface.
public final class DefaultMethodSignature extends Primordial implements Data {
    private String returnValue;

    public DefaultMethodSignature(String returnValue) {
        if (returnValue == null) throw new IllegalArgumentException();
        this.returnValue = returnValue;
    }

    public String getReturnValue() {
        return returnValue;
    }
}
