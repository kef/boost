package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.gunge.type.Data;

public interface StartEnd extends Data {
    TimeSpec getStart();

    TimeSpec getEnd();
}
