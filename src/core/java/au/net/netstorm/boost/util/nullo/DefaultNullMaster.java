package au.net.netstorm.boost.util.nullo;

import java.io.Serializable;

// FIXME: SC502 Where is this used?  Instancise.
// FIXME: SC502 Test serializable in NullAT.

public final class DefaultNullMaster implements NullMaster, Serializable {
    public void check(Object parameter, String parameterName) {
        if (parameter == null) throw new IllegalArgumentException(parameterName + " parameter should not be null");
    }

    // Note. In for JDK 1.5 support, will be exposed as varargs, i.e. check(foo, bar, baz)
    public void check(Object[] parameters) {
        if (parameters == null) throw new IllegalArgumentException("Parameter 1 should not be null");
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] == null) {
                throw new IllegalArgumentException("Parameter " + (i + 1) + " should not be null");
            }
        }
    }
}
