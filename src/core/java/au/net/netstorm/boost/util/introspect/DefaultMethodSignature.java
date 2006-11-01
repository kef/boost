package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 525 Extract interface.
public final class DefaultMethodSignature extends Primordial implements Data {
    private Object returnValue;

    public DefaultMethodSignature(Object returnValue) {
        this.returnValue = returnValue;
    }

    public Object getReturnValue() {
        return returnValue;
    }
}
