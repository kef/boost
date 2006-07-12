package au.net.netstorm.boost.util.nullo;

import java.io.Serializable;

// FIXME: SC502 Where is this used?  Instancise.
// FIXME: SC502 Test serializable in NullAT.

public final class DefaultNullMaster implements Serializable, NullMaster {
    // FIXME: SC502 INSTANCE pattern.

    public void check(Object parameter, String message) {
        if (parameter == null) throw new IllegalArgumentException(message + " parameter should not be null");
    }
}
