package au.net.netstorm.boost.util.nullo;

import java.io.Serializable;

// FIXME: SC502 Where is this used?  Instancise. 
// FIXME: SC502 Test serializable in NullAT.

public class NullMaster implements Serializable {
    // FIXME: SC502 INSTANCE pattern.

    public void check(Object parameter) {
        if (parameter == null) throw new IllegalArgumentException();
    }
}
