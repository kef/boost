package au.net.netstorm.boost.time.core;

// FIX SC507 Introduce type stuff.
// FIX SC502 Test drive requirement for "Data".  This was placed here to get external requirement complete
// FIX SC502 whilst cruise was broken!

// FIX SC502 Should be "immutable", not "Data".
public final class DefaultTimePoint implements TimePoint {
    private static final long EPOCH_MILLIS = 0L;
    private static final long EPOCH_ARGMAGEDDON = Long.MAX_VALUE;
    public static final TimePoint EPOCH = new DefaultTimePoint(EPOCH_MILLIS);
    public static final TimePoint ARMAGGEDON = new DefaultTimePoint(EPOCH_ARGMAGEDDON);
    private final long millis;

    public DefaultTimePoint(long millis) {
        this.millis = millis;
        validate();
    }

    public String toString() {
        return "TimePoint[" + millis + "]";
    }

    public boolean equals(Object o) {
        if (!(o instanceof DefaultTimePoint)) return false;
        return equals((TimePoint) o);
    }

    public int hashCode() {
        return (int) millis;
    }

    private void validate() {
        if (millis < EPOCH_MILLIS) throw new IllegalArgumentException(
                "The specified time (time=" + millis + ") cannot be less than the epoch (EPOCH=" + EPOCH + ").");
    }

    private boolean equals(TimePoint time) {
        return time.getMillis() == millis;
    }

    public long getMillis() {
        return millis;
    }

    /*
              _____
           _.'_____`._
         .'.-'  12 `-.`.   SINCE DAYLIGHT SAVINGS TIME ISN'T WRECKED UP ENOUGH
        /,' 11      1 `.\   LET'S KIND OF RANDOMLY CHANGE IT JUST TO
       // 10      /   2 \\   MAKE THINGS MORE DIFFICULT
      ;;         /       ::
      || 9  ----O      3 ||
      ::                 ;;
       \\ 8           4 //
        \`. 7       5 ,'/
         '.`-.__6__.-'.'
          ((-._____.-))
          _))       ((_
         '--'SSt    '--'
    
     */
}
