package au.net.netstorm.boost.test.timing;

public class DefaultTimingSupport implements TimingSupport {

    // FIX 2000 Is this what we want to do as the default timing log?
    // OK GenericIllegalRegexp {
    public void time(Class cls, String method, long start, long end) {
        TimingDetails details = new DefaultTimingDetails(cls, method, start, end);
        System.out.println(details);
    }
    // } OK GenericIllegalRegexp
}
