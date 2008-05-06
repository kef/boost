package au.net.netstorm.boost.gunge.nullo;

import au.net.netstorm.boost.gunge.array.ArrayFlattener;
import au.net.netstorm.boost.gunge.array.DefaultArrayFlattener;

import java.io.Serializable;

// FIX SC502 Where is this used?

// FIX SC502 Test serializable in NullAT.
public final class DefaultNullMaster implements NullMaster, Serializable {
    private static final ArrayFlattener FLATTENER = new DefaultArrayFlattener();

    // FIX 2328 This method sucks.  Delete it.
    public void check(Object parameter, String parameterName) {
        if (parameter == null) throw new IllegalArgumentException(parameterName + " parameter cannot be null");
    }

    public void check(Object parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException();
        }
    }

    public void check(Object... parameters) {
        if (parameters == null) throw new IllegalArgumentException("Parameters cannot be null");
        checkElements(parameters);
    }

    private void checkElements(Object... parameters) {
        Object[] flattened = FLATTENER.flatten(parameters);
        for (int i = 0; i < flattened.length; i++) {
            check(i, flattened[i]);
        }
    }

    private void check(int i, Object ref) {
        if (ref == null) throw new IllegalArgumentException("Parameter " + (i + 1) + " cannot be null");
    }
}
