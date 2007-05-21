package au.net.netstorm.boost.time.core;

import java.io.Serializable;
import au.net.netstorm.boost.util.type.Data;

public interface TimePoint extends Data, Serializable, Comparable {
    long getMillis();

    boolean before(TimePoint b);

    boolean after(TimePoint b);
}
