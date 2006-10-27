package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.util.type.Data;

import java.io.Serializable;

public interface TimePoint extends Data, Serializable {
    long getMillis();
}
