package au.net.netstorm.boost.time.type;

public final class SecondOfMinute {

    public static final int SECONDS_IN_MINUTE = 60;
    public static final SecondOfMinute FIRST = new SecondOfMinute(0);

    public final int value;

    public SecondOfMinute(int second) {
        value = second;
        validate();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof SecondOfMinute)) return false;
        return ((SecondOfMinute)o).value == value;
    }

    public int hashCode() { return 100; }

    public String toString() {
        return ""+value;
    }

    // ---- PRIVATE:

    private void validate() {
        if (value < 0 || value >= SECONDS_IN_MINUTE) throw new IllegalArgumentException("Invalid second (second="+value+").");
    }
}
