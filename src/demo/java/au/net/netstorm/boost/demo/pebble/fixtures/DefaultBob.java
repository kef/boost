package au.net.netstorm.boost.demo.pebble.fixtures;

public final class DefaultBob implements Bob {
    private JobCreator newJobCreator;

    public DefaultBob(String comment) {
    }

    public JobCreator getNewJobCreator() {
        return newJobCreator;
    }
}
