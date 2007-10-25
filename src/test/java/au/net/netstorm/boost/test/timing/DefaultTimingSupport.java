package au.net.netstorm.boost.test.timing;

public class DefaultTimingSupport implements TimingSupport {

    public void time(Class cls, String method, long start, long end) {
        TimingDetails details = new DefaultTimingDetails(cls, method, start, end);
        // Reinstate to see timing output.
        // log(details);
    }

    private void log(TimingDetails details) {
        // OK GenericIllegalRegexp {
        System.out.println(details);
        // } OK GenericIllegalRegexp
    }
}
