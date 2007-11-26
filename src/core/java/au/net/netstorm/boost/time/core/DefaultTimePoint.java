package au.net.netstorm.boost.time.core;

// FIX SC502 Should be "immutable", not "Data".
public final class DefaultTimePoint implements TimePoint {
    private static final Long EPOCH_MILLIS = 0L;
    private static final Long EPOCH_ARMAGEDDON = Long.MAX_VALUE;
    public static final TimePoint EPOCH = new DefaultTimePoint(EPOCH_MILLIS);
    public static final TimePoint ARMAGEDDON = new DefaultTimePoint(EPOCH_ARMAGEDDON);
    private final Long millis;

    public DefaultTimePoint(long millis) {
        this.millis = millis;
        validate();
    }

    public Long getMillis() {
        return millis;
    }

    // FIX 51915 Move these two dodgy boys into TimeMaster or TimeRangeMaster.
    public Boolean before(TimePoint timePoint) {
        return compareTo(timePoint) < 0;
    }

    public Boolean after(TimePoint timePoint) {
        return compareTo(timePoint) > 0;
    }

    public String toString() {
        return "TimePoint[" + millis + "]";
    }

    public boolean equals(Object o) {
        if (!(o instanceof DefaultTimePoint)) return false;
        return millis.equals(((DefaultTimePoint) o).millis);
    }

    public int hashCode() {
        return millis.intValue();
    }

    public int compareTo(Object o) {
        TimePoint timePoint = (TimePoint) o;
        Long millis = timePoint.getMillis();
        if (this.millis < millis) return -1;
        if (this.millis > millis) return 1;
        return 0;
    }

    private void validate() {
        if (millis < EPOCH_MILLIS) throw new IllegalArgumentException(
                "The specified time (time=" + millis + ") cannot be less than the epoch (EPOCH=" + EPOCH + ").");
    }

    /*
              _____
           _.'_____`._
         .'.-'  12 `-.`.   SINCE DAYLIGHT SAVINGS TIME ISN'T WRECKED ENOUGH
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
         '--'       '--'

     */
}
