package au.net.netstorm.boost.gunge.nullo;

import java.io.Serializable;

// FIX SC502 Where is this used?

// FIX SC502 Test serializable in NullAT.
public final class DefaultNullMaster implements NullMaster, Serializable {
    public void check(Object parameter) {
        if (parameter == null) throw new IllegalArgumentException("Parameter cannot be null");
    }

    public void check(Object... parameters) {
        check((Object) parameters);
        for (int i = 0; i < parameters.length; ++i) check(i, parameters[i]);
    }

    private void check(int i, Object ref) {
        if (ref == null) throw new IllegalArgumentException("Parameter " + (i + 1) + " cannot be null");
    }
}
