package au.net.netstorm.boost.bullet.time.core;

import java.io.Serializable;

// FIX 1914 Make extend Primordial.

// FIX 1914 Range provider.
public final class Duration implements Serializable {
    public static final Duration QUANTUM = new Duration(1L);
    public final long millis;

    public Duration(long millis) {
        this.millis = millis;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Duration)) return false;
        return equals((Duration) o);
    }

    public int hashCode() {
        return (int) millis;
    }

    private void validate() {
        if (!(millis > 0)) throw new IllegalArgumentException("The duration must be at least ONE millisecond long");
    }

    private boolean equals(Duration duration) {
        return duration.millis == millis;
    }
}

