package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.primordial.Primordial;

public class DefaultTimingDetails extends Primordial implements TimingDetails {
    private final Class cls;
    private final String method;
    private final long start;
    private final long end;
    private final long duration;

    public DefaultTimingDetails(Class cls, String method, long start, long end) {
        this.cls = cls;
        this.method = method;
        this.start = start;
        this.end = end;
        this.duration = end - start;
    }

    public Class getCls() {
        return cls;
    }

    public String getMethod() {
        return method;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public long getDuration() {
        return duration;
    }
}
