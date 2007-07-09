package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.util.type.Data;

public interface Rocket extends Data {
    // FIX 2076 Of course rockets have multiple fins.  However our framework does not yet support dummy arrays.
    Fin getFin();

    Nose getNose();
}
