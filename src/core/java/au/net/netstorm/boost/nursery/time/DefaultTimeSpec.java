package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.time.core.TimePoint;

// DEBT LineLength {
final class DefaultTimeSpec extends Primordial implements TimeSpec {
    private static final TimeType ABSOLUTE = TimeType.ABSOLUTE;
    private static final TimeType RELATIVE = TimeType.RELATIVE;
    private static final TimeType NONE = TimeType.NONE;
    private final TimePoint absolute;
    private final Relative relative;
    private final TimeType type;

    DefaultTimeSpec(TimePoint absolute, Relative relative, TimeType type) {
        this.absolute = absolute;
        this.relative = relative;
        this.type = type;
        validate();
    }

    public TimePoint getAbsolute() {
        ensure(ABSOLUTE);
        return absolute;
    }

    public Relative getRelative() {
        ensure(RELATIVE);
        return relative;
    }

    public TimeType getType() {
        return type;
    }

    private void validate() {
        if (type == null) throw new IllegalArgumentException();
        if (!ok()) explode();
    }

    // OK CyclomaticComplexity|ReturnCount {
    private boolean ok() {
        if (type.equals(ABSOLUTE)) return relative == null;
        if (type.equals(RELATIVE)) return absolute == null;
        if (type.equals(NONE)) return absolute == null && relative == null;
        return false;
    } // } OK CyclomaticComplexity|ReturnCount

    private void ensure(TimeType type) {
        if (!this.type.equals(type)) pop(type);
    }

    // FIX 1914 Specific exception.
    private void explode() {
        throw new IllegalStateException("Values of absolute/relative " + absolute + "/" + relative + " do not match " + type + ".");
    }

    // FIX 1914 Specific exception.
    private void pop(TimeType type) {
        throw new IllegalStateException("Time specification is not " + type + ".");
    }
}
// } DEBT LineLength
