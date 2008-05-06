package au.net.netstorm.boost.bullet.time.type;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class SecondOfMinute extends Primordial {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final SecondOfMinute FIRST = new SecondOfMinute(0);
    public final int value;

    public SecondOfMinute(int second) {
        value = second;
        validate();
    }

    private void validate() {
        if (value < 0 || value >= SECONDS_IN_MINUTE)
            throw new IllegalArgumentException("Invalid second (second=" + value + ").");
    }
}
