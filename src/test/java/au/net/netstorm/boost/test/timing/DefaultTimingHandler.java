package au.net.netstorm.boost.test.timing;

public class DefaultTimingHandler implements TimingHandler {

    public void time(TimingDetails details) {
        doNothing();
    }

    private void doNothing() {
    }
}
