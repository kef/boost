package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.util.array.ArrayFlattener;
import au.net.netstorm.boost.util.array.DefaultArrayFlattener;

import java.io.Serializable;

// FIX SC502 Where is this used?
// FIX SC502 Test serializable in NullAT.
public final class DefaultNullMaster implements NullMaster, Serializable {
    private static final ArrayFlattener FLATTENER = new DefaultArrayFlattener();

    public void check(Object parameter, String parameterName) {
        if (parameter == null) throw new IllegalArgumentException(parameterName + " parameter should not be null");
    }

    public void check(Object parameter) {
        if (parameter == null) throw new IllegalArgumentException();
    }

    // Note. Exposed as varargs in JDK 1.5, i.e. check(foo, bar, baz)
    public void check(Object[] parameters) {
        if (parameters == null) throw new IllegalArgumentException("Parameter 1 should not be null");
        checkElements(parameters);
    }

    private void checkElements(Object[] parameters) {
        final Object[] flattenedParameters = FLATTENER.flatten(parameters);
        for (int i = 0; i < flattenedParameters.length; i++) {
            if (flattenedParameters[i] == null) {
                throw new IllegalArgumentException("Parameter " + (i + 1) + " should not be null");
            }
        }
    }
}
