package au.net.netstorm.boost.demo.pebble.fixtures;

public final class DefaultBob implements Bob {
    private JobNewer newJobCreator;

    public DefaultBob(String comment) {
    }

    public JobNewer getNewJobCreator() {
        return newJobCreator;
    }
}
