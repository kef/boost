package au.net.netstorm.boost.nursery.gunge.ref;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.Immutable;

// SUGGEST: Ref's are not really a 'Data' object.  They have an additional 'exists' method (etc.)

// SUGGEST: Data is needed to get Randomiser to play nicely.
public interface Ref extends Immutable, Data {
    boolean exists();
}
