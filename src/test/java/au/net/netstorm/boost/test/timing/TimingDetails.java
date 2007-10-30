package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.util.type.Data;

public interface TimingDetails extends Data {
    Class getCls();

    String getMethod();

    long getStart();

    long getEnd();

    long getDuration();
}
